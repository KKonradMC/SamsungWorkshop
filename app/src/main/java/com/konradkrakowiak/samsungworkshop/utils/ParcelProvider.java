package com.konradkrakowiak.samsungworkshop.utils;

import android.os.Parcelable;

import org.parceler.Parcels;

import javax.inject.Inject;

/**
 * Created by Konrad on 27/10/15.
 */
public class ParcelProvider {

    @Inject
    public ParcelProvider() {
    }

    public <T> T unwrap(Parcelable parcelable) {
        return Parcels.unwrap(parcelable);
    }

    public <T> Parcelable wrap(T value) {
        return Parcels.wrap(value);
    }
}
