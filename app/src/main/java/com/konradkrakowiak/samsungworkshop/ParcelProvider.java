package com.konradkrakowiak.samsungworkshop;

import android.os.Parcelable;

import org.parceler.Parcel;
import org.parceler.Parcels;

import javax.inject.Inject;

public class ParcelProvider {
    @Inject
    ParcelProvider() {
    }

    public <T> Parcelable wrap(T value){
        return Parcels.wrap(value);
    }

    public <T> T unwrap(Parcelable value){
        return Parcels.unwrap(value);
    }
}
