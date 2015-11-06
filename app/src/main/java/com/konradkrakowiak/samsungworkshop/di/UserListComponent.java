package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;

import com.konradkrakowiak.samsungworkshop.ui.UserDetailsActivity;
import com.konradkrakowiak.samsungworkshop.ui.UserListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by k.talanda on 2015-10-28.
 */
@Singleton
@Component(modules = {
        UIModule.class,
        UtilModule.class,
        RetrofitModule.class,
        IntentModule.class,
        UniversalImageLoaderModule.class})
public interface UserListComponent {

    void inject(UserListActivity userListActivity);

    void inject(UserDetailsActivity userDetailsActivity);

    class Initializer{
        public static UserListComponent init(Context context){
            return DaggerUserListComponent
                    .builder()
                    .intentModule(new IntentModule(context))
                    .uIModule(new UIModule(context))
                    .universalImageLoaderModule(new UniversalImageLoaderModule(context))
                    .build();
        }
    }
}