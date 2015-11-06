package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.UserListApp;
import com.konradkrakowiak.samsungworkshop.listener.OnUserListItemClickListener;
import com.konradkrakowiak.samsungworkshop.model.Order;
import com.konradkrakowiak.samsungworkshop.model.Sort;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.konradkrakowiak.samsungworkshop.model.UserList;
import com.konradkrakowiak.samsungworkshop.network.UserApiClient;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class UserListActivity extends AppCompatActivity implements OnUserListItemClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_list)
    RecyclerView userList;
    @Bind(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeToRefresh;
    @Inject
    RecyclerView.LayoutManager linearLayoutManager;

    @Inject
    Retrofit retrofit;

    @Inject
    UserListAdapter userListAdapter;

    @Inject
    IntentFactory intentFactory;

    Subscription stackoverflow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserListApp.userListComponent(this).inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
        prepareUserList();


        //callRetrofitStandard();
        callRxStandard();
    }

    private void callRetrofitStandard() {
        Call<UserList> userListCall = retrofit.create(UserApiClient.class).getUsers(null, null, null, null, Order.asc, null, null, Sort.name, null, "stackoverflow");
        userListCall.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Response<UserList> response, Retrofit retrofit) {
                userListAdapter.addUsers(response.body());
                userListAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    private void callRxStandard() {
        stackoverflow = retrofit
                .create(UserApiClient.class)
                .getUsersRx(
                        null,
                        null,
                        null,
                        null,
                        Order.asc,
                        null,
                        null,
                        Sort.name,
                        null,
                        "stackoverflow")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<UserList>() {
                            @Override
                            public void call(UserList users) {
                                userListAdapter.addUsers(users);
                                userListAdapter.notifyDataSetChanged();
                            }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                Toast.makeText(UserListActivity.this, throwable.getClass().toString(), Toast.LENGTH_LONG).show();
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {

                            }
                        }
                );
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        userListAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        userListAdapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPause() {
        if (stackoverflow != null) {
            stackoverflow.unsubscribe();
        }
        super.onPause();
    }

    void prepareUserList() {
        userList.setLayoutManager(linearLayoutManager);
        userList.setAdapter(userListAdapter);
        userListAdapter.setOnUserListItemClickListener(this);
    }

    @Override
    public void onUserItemClick(User user) {
        startActivity(intentFactory.forDisplayUserDetails(user));
    }
}
