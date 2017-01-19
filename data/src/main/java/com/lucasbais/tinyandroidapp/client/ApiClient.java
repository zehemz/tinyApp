package com.lucasbais.tinyandroidapp.client;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */


public interface ApiClient {

    @GET("1.1/search/tweets.json")
    Single<String> query(@Query("q") String sort);

    @POST("oauth2/token")
    Single<AuthUser> auth();

}

