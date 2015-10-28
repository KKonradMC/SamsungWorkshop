package com.konradkrakowiak.samsungworkshop;

import android.app.Application;
import android.content.Context;

import com.konradkrakowiak.samsungworkshop.di.UsersListComponent;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class UsersListApp extends Application {

    private UsersListComponent component;

    public static UsersListComponent component(Context context) {
        return ((UsersListApp) context.getApplicationContext()).component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = UsersListComponent.Initializer.init(this);
    }
}
