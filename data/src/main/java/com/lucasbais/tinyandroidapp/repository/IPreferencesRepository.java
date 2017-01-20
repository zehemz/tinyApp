package com.lucasbais.tinyandroidapp.repository;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

/**
 * Created by zehemz on 18/01/2017.
 */

public interface IPreferencesRepository {
    String getAppSettings();

    AuthUser getAuthUser();

    void setUser(AuthUser authUser);
}
