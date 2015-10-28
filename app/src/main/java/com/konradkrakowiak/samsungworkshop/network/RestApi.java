package com.konradkrakowiak.samsungworkshop.network;

/**
 * Created by przemyslawlukasz on 28/10/15.
 */
public interface RestApi {

    String HOST = "api.stackexchange.com";
    String SCHEME = "http";

    interface EndPoint {
        String USER_API_CLIENT = "/2.2/users/";

    }

    interface Query {
        String PAGE = "page";
        String PAGESIZE = "pagesize";
        String FROMDATE = "fromdate";
        String TODATE = "todate";
        String ORDER = "order";
        String MIN = "min";
        String MAX = "max";
        String SORT = "sort";
        String INNAME = "inname";
        String SIZE = "size";
    }
}
