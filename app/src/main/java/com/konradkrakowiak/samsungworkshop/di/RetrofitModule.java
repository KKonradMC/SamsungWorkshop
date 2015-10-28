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

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
@Module
public class RetrofitModule {

    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, BaseUrl baseUrl, Converter.Factory converterFactory) {
        return builder
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .build();
    }

    @Provides
    Converter.Factory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    HttpUrl provideHttpUrl(HttpUrl.Builder builder) {
        return builder.scheme(RestApi.SCHEME).host(RestApi.HOST).build();
    }

    @Provides
    HttpUrl.Builder provideHttpBuilder() {
        return new HttpUrl.Builder();
    }

    @Provides
    BaseUrl provideBaseUrl() {
        return new StackUrl();
    }
}
