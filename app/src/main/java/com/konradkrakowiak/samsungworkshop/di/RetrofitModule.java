package com.konradkrakowiak.samsungworkshop.di;

import com.konradkrakowiak.samsungworkshop.network.RestApi;
import com.konradkrakowiak.samsungworkshop.network.StackUrl;
import com.squareup.okhttp.HttpUrl;

import dagger.Module;
import dagger.Provides;
import retrofit.BaseUrl;
import retrofit.Converter;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by k.talanda on 2015-10-28.
 */
@Module
public class RetrofitModule  {

    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder,
                             BaseUrl baseUrl,
                             Converter.Factory converterFactory){
        return builder
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    Converter.Factory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder();
    }

    @Provides
    BaseUrl provideBaseUrl(HttpUrl httpUrl){
        return new StackUrl(httpUrl);
    }
    @Provides
    HttpUrl provideHttpUrl(HttpUrl.Builder builder){
        return builder
                .scheme(RestApi.SCHEME)
                .host(RestApi.HOST)
                .build();
    }

    @Provides
    HttpUrl.Builder provideHttpUrlBuilder(){
        return new HttpUrl.Builder();
    }
}
