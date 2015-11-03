package com.konradkrakowiak.samsungworkshop.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.di.qualifier.UsersListViewHolderQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class UsersListViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.user_item_photo)
    ImageView userItemPhoto;
    @Bind(R.id.user_item_name)
    TextView userItemName;
    @Bind(R.id.user_item_reputation)
    TextView userItemReputation;
    @Bind(R.id.user_item_badges)
    BadgeView userItemBadges;
    @Inject
    ImageLoader imageLoader;

    @Inject
    public UsersListViewHolder(@UsersListViewHolderQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(User user) {
        userItemName.setText(user.getDisplayName());
        imageLoader.displayImage(user.getProfileImage(), userItemPhoto);
    }
}
