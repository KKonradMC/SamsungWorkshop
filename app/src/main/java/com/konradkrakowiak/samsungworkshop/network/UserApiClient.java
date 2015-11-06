package com.konradkrakowiak.samsungworkshop.network;

import com.konradkrakowiak.samsungworkshop.model.Order;
import com.konradkrakowiak.samsungworkshop.model.Sort;
import com.konradkrakowiak.samsungworkshop.model.UserList;

import java.util.Date;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


public interface UserApiClient {
    @GET(RestApi.EndPoint.USER)
    Call<UserList> getUsers(
            @Query(RestApi.Query.PAGE) Integer page,
            @Query(RestApi.Query.PAGE_SIZE) Integer pagesize,
            @Query(RestApi.Query.FROM_DATE) Date fromDate,
            @Query(RestApi.Query.FROM_DATE) Date toDate,
            @Query(RestApi.Query.ORDER) Order order,
            @Query(RestApi.Query.MIN) Integer min,
            @Query(RestApi.Query.MAX) Integer max,
            @Query(RestApi.Query.SORT) Sort sort,
            @Query(RestApi.Query.IN_NAME) String inname,
            @Query(RestApi.Query.SITE) String site
    );

    @GET(RestApi.EndPoint.USER)
    Observable<UserList> getUsersRx(
            @Query(RestApi.Query.PAGE) Integer page,
            @Query(RestApi.Query.PAGE_SIZE) Integer pagesize,
            @Query(RestApi.Query.FROM_DATE) Date fromDate,
            @Query(RestApi.Query.FROM_DATE) Date toDate,
            @Query(RestApi.Query.ORDER) Order order,
            @Query(RestApi.Query.MIN) Integer min,
            @Query(RestApi.Query.MAX) Integer max,
            @Query(RestApi.Query.SORT) Sort sort,
            @Query(RestApi.Query.IN_NAME) String inname,
            @Query(RestApi.Query.SITE) String site
    );
}
