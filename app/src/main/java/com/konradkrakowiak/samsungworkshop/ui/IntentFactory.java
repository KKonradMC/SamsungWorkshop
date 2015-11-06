package com.konradkrakowiak.samsungworkshop.ui;

import android.app.Activity;
import android.content.Intent;

import com.konradkrakowiak.samsungworkshop.ParcelProvider;
import com.konradkrakowiak.samsungworkshop.di.qualifier.UserDetailsActivityIntentQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;

import javax.inject.Inject;
import javax.inject.Provider;

public class IntentFactory {

    static final String USER_KEY = "USER_KEY";

    @UserDetailsActivityIntentQualifier
    @Inject
    Provider<Intent> provider;

    @Inject
    ParcelProvider parcelProvider;


    @Inject
    IntentFactory() {

    }

    Intent forDisplayUserDetails(User user) {
        Intent intent = provider.get();
        intent.putExtra(USER_KEY, parcelProvider.wrap(user));
        return intent;
    }
}
