package com.konradkrakowiak.samsungworkshop.di;

import com.konradkrakowiak.samsungworkshop.di.qualifier.ArrayListQualifier;
import com.konradkrakowiak.samsungworkshop.di.qualifier.LinkedListQualifier;
import com.konradkrakowiak.samsungworkshop.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
@Module
public class UtilModule {

    @LinkedListQualifier
    @Provides
    public List<User> provideLinkedUsersList() {
        return new LinkedList<User>();
    }

    @ArrayListQualifier
    @Provides
    public List<User> provideArrayUsersList() {
        return new ArrayList<User>();
    }

}
