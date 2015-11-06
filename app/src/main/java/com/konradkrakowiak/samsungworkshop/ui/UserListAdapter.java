package com.konradkrakowiak.samsungworkshop.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konradkrakowiak.samsungworkshop.ParcelProvider;
import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.di.UniversalImageLoaderModule;
import com.konradkrakowiak.samsungworkshop.di.qualifier.LinkedListQualifier;
import com.konradkrakowiak.samsungworkshop.listener.OnUserListItemClickListener;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.konradkrakowiak.samsungworkshop.model.UserList;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.parceler.Parcels;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

public class UserListAdapter extends RecyclerView.Adapter<UserItemViewHolder>implements View.OnClickListener {

    @LinkedListQualifier
    @Inject
    List<User> userList;

    @Inject
    Provider<UserItemViewHolder> viewHolder;

    @Inject
    ParcelProvider parcelProvider;

    OnUserListItemClickListener onUserListItemClickListener;

    @Inject
    UserListAdapter() {
    }

    public void setOnUserListItemClickListener(OnUserListItemClickListener onUserListItemClickListener) {
        this.onUserListItemClickListener = onUserListItemClickListener;
    }

    void addUsers(Collection<User> users){
        userList.addAll(users);
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final UserItemViewHolder userItemViewHolder = viewHolder.get();
        userItemViewHolder.itemView.setOnClickListener(this);
        return userItemViewHolder;
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void addUsers(UserList users) {
        for (User user : users){
            userList.add(user);
        }
    }

    public void onSaveInstanceState(Bundle outState) {

        Parcelable parcelable = parcelProvider.wrap(userList);
        outState.putParcelable("Zmienna", parcelable);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        Parcelable parcelable = savedInstanceState.getParcelable("Zmienna");
        List<User> unwrap = parcelProvider.unwrap(parcelable);
        userList.addAll(unwrap);
    }

    @Override
    public void onClick(View v) {
        if(onUserListItemClickListener != null){
            onUserListItemClickListener.onUserItemClick((User) v.getTag());
        }
    }
}
