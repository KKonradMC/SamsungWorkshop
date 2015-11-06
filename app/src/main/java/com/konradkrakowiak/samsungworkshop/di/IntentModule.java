package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;
import android.content.Intent;

import com.konradkrakowiak.samsungworkshop.di.qualifier.UserDetailsActivityIntentQualifier;
import com.konradkrakowiak.samsungworkshop.ui.UserDetailsActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class IntentModule {

    private Context context;

    IntentModule(Context context){

        this.context = context;
    }

    @UserDetailsActivityIntentQualifier
    @Provides
    Intent provideDetailsActivity(){
        return new Intent(context, UserDetailsActivity.class);
    }
}
