package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konradkrakowiak.samsungworkshop.R;
import com.konradkrakowiak.samsungworkshop.di.qualifier.UserListItemViewQualifier;
import com.konradkrakowiak.samsungworkshop.ui.UserItemViewHolder;

import javax.inject.Qualifier;

import dagger.Module;
import dagger.Provides;

/**
 * Created by k.talanda on 2015-10-28.
 */
@Module
class UIModule {
    private final Context context;

    UIModule(Context context){
        this.context = context;
    }
    @Provides
    RecyclerView.LayoutManager provideLinearLayoutManager(){
        return new LinearLayoutManager(context);
    }

    @Provides
    LayoutInflater provideLayoutInflater(){
        return LayoutInflater.from(context);
    }

    @UserListItemViewQualifier
    @Provides
    View provideUserListItemView(LayoutInflater layoutInflater){
        return layoutInflater.inflate(R.layout.view_user_list_item, null);
    }

}
