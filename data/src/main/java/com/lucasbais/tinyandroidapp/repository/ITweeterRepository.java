package com.lucasbais.tinyandroidapp.repository;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */

public interface ITweeterRepository {
    Single<AuthUser> auth();
}
