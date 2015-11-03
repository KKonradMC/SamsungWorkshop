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
import com.konradkrakowiak.samsungworkshop.model.User;
import com.konradkrakowiak.samsungworkshop.model.UserList;
import com.konradkrakowiak.samsungworkshop.network.UsersListClient;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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
