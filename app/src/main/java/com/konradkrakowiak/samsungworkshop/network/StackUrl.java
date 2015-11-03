package com.konradkrakowiak.samsungworkshop.network;

import com.squareup.okhttp.HttpUrl;

import javax.inject.Inject;

import retrofit.BaseUrl;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public class StackUrl implements BaseUrl {

    HttpUrl baseUrl;

    public StackUrl(HttpUrl baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public HttpUrl url() {
        return baseUrl;
    }
}
