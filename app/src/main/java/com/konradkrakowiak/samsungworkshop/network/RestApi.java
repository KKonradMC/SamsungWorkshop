package com.konradkrakowiak.samsungworkshop.network;

public interface RestApi {
    String SCHEME = "http";
    String HOST = "api.stackexchange.com";
    interface EndPoint{
        String USER = "/2.2/users";
    }
    interface Query{
        String PAGE = "page";
        String PAGE_SIZE = "pagesize";
        String FROM_DATE = "fromdate";
        String TO_DATE = "todate";
        String ORDER = "order";
        String MIN = "min";
        String MAX = "max";
        String SORT = "sort";
        String IN_NAME = "inname";
        String SITE = "site";
    }
}
