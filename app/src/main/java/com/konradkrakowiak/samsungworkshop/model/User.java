package com.konradkrakowiak.samsungworkshop.model;


import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

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

@Parcel
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

    @SerializedName(Metadata.BADGE_COUNTS)
    BadgeCounts badgeCounts;

    @SerializedName(Metadata.ACCOUNT_ID)
    long accountId;

    @SerializedName(Metadata.IS_EMPLOYEE)
    boolean isEmployee;

    @SerializedName(Metadata.LAST_MODIFIED_DATE)
    long lastModifiedDate;

    @SerializedName(Metadata.LAST_ACCESS_DATE)
    long lastAccessDate;

    @SerializedName(Metadata.REPUTATION_CHANGE_YEAR)
    int reputationChangeYear;

    @SerializedName(Metadata.REPUTATION_CHANGE_QUARTER)
    int reputationChangeQuarter;

    @SerializedName(Metadata.REPUTATION_CHANGE_MONTH)
    int reputationChangeMonth;

    @SerializedName(Metadata.REPUTATION_CHANGE_WEEK)
    int reputationChangeWeek;

    @SerializedName(Metadata.REPUTATION_CHANGE_DAY)
    int reputationChangeDay;

    @SerializedName(Metadata.REPUTATION)
    int reputation;

    @SerializedName(Metadata.CREATION_DATE)
    long creationDate;

    @SerializedName(Metadata.USER_TYPE)
    UserType userType;

    @SerializedName(Metadata.USER_ID)
    long userId;

    @SerializedName(Metadata.AGE)
    int age;

    @SerializedName(Metadata.ACCEPT_RATE)
    int acceptRate;

    @SerializedName(Metadata.LOCATION)
    String location;

    @SerializedName(Metadata.WEBSITE_URL)
    String websiteUrl;

    @SerializedName(Metadata.LINK)
    String link;

    @SerializedName(Metadata.DISPLAY_NAME)
    String displayName;

    @SerializedName(Metadata.PROFILE_IMAGE)
    String profileImage;

    public String getDisplayName(){
        return displayName;
    }

    public BadgeCounts getBadgeCounts() {
        return badgeCounts;
    }

    public void setBadgeCounts(BadgeCounts badgeCounts) {
        this.badgeCounts = badgeCounts;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(boolean isEmployee) {
        this.isEmployee = isEmployee;
    }

    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public long getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(long lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public int getReputationChangeYear() {
        return reputationChangeYear;
    }

    public void setReputationChangeYear(int reputationChangeYear) {
        this.reputationChangeYear = reputationChangeYear;
    }

    public int getReputationChangeQuarter() {
        return reputationChangeQuarter;
    }

    public void setReputationChangeQuarter(int reputationChangeQuarter) {
        this.reputationChangeQuarter = reputationChangeQuarter;
    }

    public int getReputationChangeMonth() {
        return reputationChangeMonth;
    }

    public void setReputationChangeMonth(int reputationChangeMonth) {
        this.reputationChangeMonth = reputationChangeMonth;
    }

    public int getReputationChangeWeek() {
        return reputationChangeWeek;
    }

    public void setReputationChangeWeek(int reputationChangeWeek) {
        this.reputationChangeWeek = reputationChangeWeek;
    }

    public int getReputationChangeDay() {
        return reputationChangeDay;
    }

    public void setReputationChangeDay(int reputationChangeDay) {
        this.reputationChangeDay = reputationChangeDay;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(int acceptRate) {
        this.acceptRate = acceptRate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
