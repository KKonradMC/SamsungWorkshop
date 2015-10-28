package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.di.qualifier.UsersListViewHolderQualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
@Module
class UiModule {

    private final Context context;

    UiModule(Context context) {
        this.context = context;
    }

    @Provides
    RecyclerView.LayoutManager provideLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }

    @Provides
    public LayoutInflater provideLayoutInflater() {
        return LayoutInflater.from(context);
    }

    @UsersListViewHolderQualifier
    @Provides
    public View provideUserItemViewHolder(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.view_user_list_item, null, false);
    }
}
