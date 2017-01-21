package com.lucasbais.tinyandroidapp.client;

import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.dto.TweetList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */


public interface ApiClient {

    @GET("1.1/search/tweets.json")
    Single<TweetList> query(@Header("Authorization") String authorization, @Query("q") String hashtag);

    @FormUrlEncoded
    @POST("oauth2/token")
    Single<AuthUser> auth(@Header("Authorization") String authorization,
                          @Header("Content-Type") String contentType,
                          @Field("grant_type") String grantType);

}

