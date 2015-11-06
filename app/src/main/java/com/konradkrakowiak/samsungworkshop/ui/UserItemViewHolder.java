package com.konradkrakowiak.samsungworkshop.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.di.qualifier.UserListItemViewQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserItemViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.user_item_photo)
    ImageView userItemPhoto;
    @Bind(R.id.user_item_name)
    TextView userItemName;
    @Bind(R.id.user_item_reputation)
    TextView userItemReputation;
    @Bind(R.id.user_item_badges)
    BadgeView userItemBadges;
    @Bind(R.id.main_layout)
    RelativeLayout mainLayout;
    @Inject
    ImageLoader imageLoader;

    @Inject
    public UserItemViewHolder(@UserListItemViewQualifier View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bind(User user) {
        itemView.setTag(user);
        userItemName.setText(user.getDisplayName());
        imageLoader.displayImage(user.getProfileImage(), userItemPhoto);
        userItemBadges.setBadges(user.getBadgeCounts());
    }
}
