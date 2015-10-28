package com.konradkrakowiak.samsungworkshop.network;

import com.konradkrakowiak.samsungworkshop.model.Order;
import com.konradkrakowiak.samsungworkshop.model.Sort;
import com.konradkrakowiak.samsungworkshop.model.UserList;

import java.util.Date;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public interface UsersListClient {

    @GET
    UserList getUsersList(@Query(RestApi.Query.PAGE) int page,
                          @Query(RestApi.Query.FROMDATE) Date fromdate,
                          @Query(RestApi.Query.TODATE) Date todate,
                          @Query(RestApi.Query.ORDER) Order order,
                          @Query(RestApi.Query.MIN) int min,
                          @Query(RestApi.Query.MAX) int max,
                          @Query(RestApi.Query.SORT) Sort sort,
                          @Query(RestApi.Query.INNAME) String inname,
                          @Query(RestApi.Query.SIZE) int size);
}
