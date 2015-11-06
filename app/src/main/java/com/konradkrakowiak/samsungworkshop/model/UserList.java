package com.konradkrakowiak.samsungworkshop.model;

import com.google.gson.annotations.SerializedName;

import java.util.Iterator;
import java.util.List;

public class UserList implements Iterable<User> {


    interface Metadata {

        String ITEMS = "items";
    }

    @SerializedName(Metadata.ITEMS)
    List<User> userList;

    @Override
    public Iterator<User> iterator() {
        if (userList == null) {
            return new Iterator<User>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public User next() {
                    return null;
                }

                @Override
                public void remove() {
                }
            };
        }
        return userList.iterator();
    }
}
