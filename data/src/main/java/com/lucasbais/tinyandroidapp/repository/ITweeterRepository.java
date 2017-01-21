package com.lucasbais.tinyandroidapp.repository;

import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.dto.TweetList;

import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */

public interface ITweeterRepository {
    Single<AuthUser> auth();

    Single<TweetList> search(String query);
}
