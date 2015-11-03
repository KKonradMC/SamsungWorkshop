package com.konradkrakowiak.samsungworkshop.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.konradkrakowiak.samsungworkshop.di.qualifier.ArrayListQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.konradkrakowiak.samsungworkshop.model.UserList;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class UsersListAdapter extends RecyclerView.Adapter<UsersListViewHolder> {

    @ArrayListQualifier
    @Inject
    List<User> userList;
    @Inject
    Provider<UsersListViewHolder> viewHolder;

    @Inject
    UsersListAdapter() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
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
}
