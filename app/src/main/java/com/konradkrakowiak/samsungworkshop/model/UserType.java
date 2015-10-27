package com.konradkrakowiak.samsungworkshop.model;

public enum  UserType {
    UNKNOWN, REGISTERED;

    interface Metadata{
        String REGISTERED = "REGISTERED";
    }
}
