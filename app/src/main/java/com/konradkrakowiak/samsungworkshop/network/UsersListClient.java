package com.konradkrakowiak.samsungworkshop.network;

import com.konradkrakowiak.samsungworkshop.model.Order;
import com.konradkrakowiak.samsungworkshop.model.Sort;
import com.konradkrakowiak.samsungworkshop.model.UserList;

import java.util.Date;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public interface UsersListClient {

    @GET(RestApi.EndPoint.USER_API_CLIENT)
    Call<UserList> getUsersList(@Query(RestApi.Query.PAGE) Integer page,
                                @Query(RestApi.Query.PAGESIZE) Integer pagesize,
                                @Query(RestApi.Query.FROMDATE) Date fromdate,
                                @Query(RestApi.Query.TODATE) Date todate,
                                @Query(RestApi.Query.ORDER) Order order,
                                @Query(RestApi.Query.MIN) Integer min,
                                @Query(RestApi.Query.MAX) Integer max,
                                @Query(RestApi.Query.SORT) Sort sort,
                                @Query(RestApi.Query.INNAME) String inname,
                                @Query(RestApi.Query.SITE) String site);
}
