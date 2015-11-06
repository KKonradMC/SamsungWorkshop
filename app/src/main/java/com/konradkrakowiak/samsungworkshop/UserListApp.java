package com.konradkrakowiak.samsungworkshop;

import android.app.Application;
import android.content.Context;

import com.konradkrakowiak.samsungworkshop.di.UserListComponent;

public class UserListApp extends Application {
    UserListComponent userListComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        userListComponent = UserListComponent.Initializer.init(this);
    }

    public static UserListComponent userListComponent(Context context){
        return ((UserListApp)context.getApplicationContext()).userListComponent;
    }
}
