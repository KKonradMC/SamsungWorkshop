package com.konradkrakowiak.samsungworkshop.network;

import com.squareup.okhttp.HttpUrl;

import javax.inject.Inject;

import retrofit.BaseUrl;

public class StackUrl implements BaseUrl {

    HttpUrl httpUrl;

    public StackUrl(HttpUrl httpUrl){
        this.httpUrl = httpUrl;
    }
    @Override
    public HttpUrl url() {

        return httpUrl;
    }
}
