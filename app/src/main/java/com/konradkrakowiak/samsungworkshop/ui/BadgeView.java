package com.konradkrakowiak.samsungworkshop.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.model.BadgeCounts;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class BadgeView extends LinearLayout {

    @Bind(R.id.gold_badge_view)
    TextView goldBadgeView;
    @Bind(R.id.silver_badge_view)
    TextView silverBadgeView;
    @Bind(R.id.bronze_badge_view)
    TextView bronzeBadgeView;

    public BadgeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        ButterKnife.bind(this);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_bagdes, this);
    }

    public void setBadges(BadgeCounts badges) {
        if (badges == null) {
            return;
        }
        goldBadgeView.setText(String.valueOf(badges.getGold()));
        silverBadgeView.setText(String.valueOf(badges.getSilver()));
        bronzeBadgeView.setText(String.valueOf(badges.getBronze()));
    }
}