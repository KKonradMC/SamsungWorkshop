package com.konradkrakowiak.samsungworkshop.di;

import android.content.Context;

import com.konradkrakowiak.samsungworkshop.ui.Main2Activity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
@Singleton
@Component(modules = {UiModule.class, UtilModule.class, RetrofitModule.class, ImageLoaderModule.class})
public interface UsersListComponent {

    void inject(Main2Activity mainActivity);

    class Initializer {
        public static UsersListComponent init(Context context) {
            return DaggerUsersListComponent
                    .builder()
                    .uiModule(new UiModule(context))
                    .imageLoaderModule(new ImageLoaderModule(context))
                    .build();
        }
    }

    ;
}
