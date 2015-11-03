package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.konradkrakowiak.samsungworkshop.di.qualifier.ArrayListQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.konradkrakowiak.samsungworkshop.model.UserList;
import com.konradkrakowiak.samsungworkshop.utils.ParcelProvider;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class UsersListAdapter extends RecyclerView.Adapter<UsersListViewHolder> {


    private static final String USER_LIST = "USER_LIST";

    @ArrayListQualifier
    @Inject
    List<User> userList;
    @Inject
    Provider<UsersListViewHolder> viewHolder;
    @Inject
    ParcelProvider parcelProvider;

    @Inject
    UsersListAdapter() {
    }

    public void fillUserList(List<User> userList) {
        this.userList.addAll(userList);
    }

    @Override
    public UsersListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolder.get();
    }

    @Override
    public void onBindViewHolder(UsersListViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUsers(UserList users) {
        for (User user : users) {
            userList.add(user);
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        List<User> userList = parcelProvider.unwrap(savedInstanceState.getParcelable(USER_LIST));
        fillUserList(userList);
    }

    public void saveState(Bundle outState) {
        outState.putParcelable(USER_LIST, parcelProvider.wrap(userList));
    }
}
