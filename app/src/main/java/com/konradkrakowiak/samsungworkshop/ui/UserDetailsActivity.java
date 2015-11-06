package com.konradkrakowiak.samsungworkshop.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.konradkrakowiak.samsungworkshop.ParcelProvider;
import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.UserListApp;
import com.konradkrakowiak.samsungworkshop.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserDetailsActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_details_img)
    ImageView userDetailsImg;
    @Bind(R.id.user_details_name)
    TextView userDetailsName;
    @Bind(R.id.user_details_reputation)
    TextView userDetailsReputation;
    @Bind(R.id.user_details_badges)
    BadgeView userDetailsBadges;
    @Bind(R.id.photo_container)
    LinearLayout photoContainer;
    @Bind(R.id.user_details_website)
    TextView userDetailsWebsite;
    @Bind(R.id.user_details_age)
    TextView userDetailsAge;
    @Bind(R.id.user_details_location)
    TextView userDetailsLocation;
    @Bind(R.id.user_details_reputation_change_year)
    TextView userDetailsReputationChangeYear;
    @Bind(R.id.user_details_reputation_change_quarter)
    TextView userDetailsReputationChangeQuarter;
    @Bind(R.id.user_details_reputation_change_month)
    TextView userDetailsReputationChangeMonth;
    @Bind(R.id.user_details_reputation_change_week)
    TextView userDetailsReputationChangeWeek;
    @Bind(R.id.user_details_reputation_change_day)
    TextView userDetailsReputationChangeDay;

    @Inject
    ParcelProvider parcelProvider;

    @Inject
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserListApp.userListComponent(this).inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        User user = getUserFromIntent(getIntent());
        setValues(user);
    }

    void setValues(User user){
        imageLoader.displayImage(user.getProfileImage(), userDetailsImg);
        userDetailsAge.setText(String.valueOf(user.getAge()));
        userDetailsBadges.setBadges(user.getBadgeCounts());
        userDetailsLocation.setText(user.getLocation());
        userDetailsName.setText(user.getDisplayName());
        userDetailsReputation.setText(String.valueOf(user.getReputation()));
        userDetailsReputationChangeDay.setText(String.valueOf(user.getReputationChangeDay()));
        userDetailsReputationChangeQuarter.setText(String.valueOf(user.getReputationChangeQuarter()));
        userDetailsReputationChangeMonth.setText(String.valueOf(user.getReputationChangeMonth()));
        userDetailsReputationChangeWeek.setText(String.valueOf(user.getReputationChangeWeek()));
        userDetailsReputationChangeYear.setText(String.valueOf(user.getReputationChangeYear()));
        userDetailsWebsite.setText(user.getWebsiteUrl());
    }

    User getUserFromIntent(Intent intent){
        Parcelable parcelable = intent.getParcelableExtra(IntentFactory.USER_KEY);
        User user = parcelProvider.unwrap(parcelable);
        return user;
    }
}
