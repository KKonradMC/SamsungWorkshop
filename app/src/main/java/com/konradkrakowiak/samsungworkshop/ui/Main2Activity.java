package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.UsersListApp;
import com.konradkrakowiak.samsungworkshop.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        UsersListApp.component(this).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
        prepareUsersList();
    }

    void prepareUsersList() {
        userList.setLayoutManager(linearLayoutManager);
        userList.setAdapter(adapter);
        List<User> list = new ArrayList<User>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        list.add(new User());
        adapter.userList.addAll(list);
        adapter.notifyDataSetChanged();
    }
}
