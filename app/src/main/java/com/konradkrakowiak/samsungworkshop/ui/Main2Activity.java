package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.UsersListApp;
import com.konradkrakowiak.samsungworkshop.model.Order;
import com.konradkrakowiak.samsungworkshop.model.Sort;
import com.konradkrakowiak.samsungworkshop.model.UserList;
import com.konradkrakowiak.samsungworkshop.network.UsersListClient;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class Main2Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_list)
    android.support.v7.widget.RecyclerView userList;
    @Bind(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeToRefresh;
    @Inject
    RecyclerView.LayoutManager linearLayoutManager;
    @Inject
    UsersListAdapter adapter;
    @Inject
    Retrofit retrofit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        UsersListApp.component(this).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
        prepareUsersList();
        executeRetrofitRx();
    }

    private void executeRetrofit() {
        retrofit.create(UsersListClient.class)
                .getUsersList(null, null, null, null, Order.desc, null, null, Sort.creation, null, "stackoverflow")
                .enqueue(new Callback<UserList>() {
                    @Override
                    public void onResponse(Response<UserList> response, Retrofit retrofit) {
                        adapter.addUsers(response.body());
                        adapter.notifyDataSetChanged();
                        ;
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Toast.makeText(Main2Activity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void executeRetrofitRx() {
        retrofit.create(UsersListClient.class)
                .getUsersListRx(null, null,
                        null, null,
                        Order.desc, null,
                        null, Sort.creation, null,
                        "stackoverflow")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<UserList>() {
                            @Override
                            public void call(UserList users) {
                                adapter.addUsers(users);
                                adapter.notifyDataSetChanged();
                            }
                        },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                Toast.makeText(Main2Activity.this, throwable.getClass().getSimpleName(), Toast.LENGTH_LONG).show();
                            }
                        },
                        new Action0() {
                            @Override
                            public void call() {

                            }
                        }
                );
    }

    void prepareUsersList() {
        userList.setLayoutManager(linearLayoutManager);
        userList.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}
