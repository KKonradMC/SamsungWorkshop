package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.konradkrakowiak.samsungworkshop.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_list)
    android.support.v7.widget.RecyclerView userList;
    @Bind(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeToRefresh;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_user_list);
        ButterKnife.bind(this);
    }
}
