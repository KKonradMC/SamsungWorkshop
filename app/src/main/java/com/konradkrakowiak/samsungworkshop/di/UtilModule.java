package com.konradkrakowiak.samsungworkshop.di;

import android.content.Intent;

import com.konradkrakowiak.samsungworkshop.di.qualifier.ArrayListQualifier;
import com.konradkrakowiak.samsungworkshop.di.qualifier.LinkedListQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by k.talanda on 2015-10-28.
 */
@Module
public class UtilModule {

    @LinkedListQualifier
    @Provides
    List<User> provideUserLinkedList(){
        return new LinkedList<>();
    }

    @ArrayListQualifier
    @Provides
    List<User> provideUserArrayList(){
        return new ArrayList<>();
    }

    @Provides
    Intent provideIntent(){
        return new Intent();
    }
}
