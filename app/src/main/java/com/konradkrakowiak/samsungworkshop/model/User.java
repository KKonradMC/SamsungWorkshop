package com.konradkrakowiak.samsungworkshop.model;


/**POJO for json like:
 *                                                                                                                   <br />
 *   {                                                                                                               <br />
 *       "badge_counts": {                                                                                           <br />
 *           ...                                                                                                     <br />
 *       },                                                                                                          <br />
 *       "account_id": 11683,                                                                                        <br />
 *       "is_employee": false,                                                                                       <br />
 *       "last_modified_date": 1426863582,                                                                           <br />
 *       "last_access_date": 1427096216,                                                                             <br />
 *       "reputation_change_year": 22917,                                                                            <br />
 *       "reputation_change_quarter": 22917,                                                                         <br />
 *       "reputation_change_month": 6492,                                                                            <br />
 *       "reputation_change_week": 400,                                                                              <br />
 *       "reputation_change_day": 155,                                                                               <br />
 *       "reputation": 762033,                                                                                       <br />
 *       "creation_date": 1222430705,                                                                                <br />
 *       "user_type": "registered",                                                                                  <br />
 *       "user_id": 22656,                                                                                           <br />
 *       "age": 38,                                                                                                  <br />
 *       "accept_rate": 83,                                                                                          <br />
 *       "location": "Reading, United Kingdom",                                                                      <br />
 *       "website_url": "http://csharpindepth.com",                                                                  <br />
 *       "link": "http://stackoverflow.com/users/22656/jon-skeet",                                                   <br />
 *       "display_name": "Jon Skeet",                                                                                <br />
 *       "profile_image": "https://www.gravatar.com/avatar/6d8ebb117e8d83d74ea95fbdd0f87e13?s=128&d=identicon&r=PG"  <br />
 *   }
 */

public class User {

    interface Metadata {
        String BADGE_COUNTS = "badge_counts";
        String ACCOUNT_ID ="account_id";
        String IS_EMPLOYEE ="is_employee";
        String LAST_MODIFIED_DATE ="last_modified_date";
        String LAST_ACCESS_DATE ="last_access_date";
        String REPUTATION_CHANGE_YEAR ="reputation_change_year";
        String REPUTATION_CHANGE_QUARTER ="reputation_change_quarter";
        String REPUTATION_CHANGE_MONTH ="reputation_change_month";
        String REPUTATION_CHANGE_WEEK ="reputation_change_week";
        String REPUTATION_CHANGE_DAY ="reputation_change_day";
        String REPUTATION ="reputation";
        String CREATION_DATE ="creation_date";
        String USER_TYPE ="user_type";
        String USER_ID ="user_id";
        String AGE ="age";
        String ACCEPT_RATE ="accept_rate";
        String LOCATION ="location";
        String WEBSITE_URL ="website_url";
        String LINK ="link";
        String DISPLAY_NAME ="display_name";
        String PROFILE_IMAGE ="profile_image";



    }

    BadgeCounts badgeCounts;

    long accountId;

    boolean isEmployee;

    long lastModifiedDate;

    long lastAccessDate;

    int reputationChangeYear;

    int reputationChangeQuarter;

    int reputationChangeMonth;

    int reputationChangeWeek;

    int reputationChangeDay;

    int reputation;

    long creationDate;

    UserType userType;

    long userId;

    int age;

    int acceptRate;

    String location;

    String websiteUrl;

    String link;

    String displayName;

    String profileImage;

}
