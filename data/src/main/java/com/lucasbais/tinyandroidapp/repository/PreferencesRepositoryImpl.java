package com.lucasbais.tinyandroidapp.repository;

import android.content.SharedPreferences;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

/**
 * Created by zehemz on 18/01/2017.
 */

public class PreferencesRepositoryImpl implements IPreferencesRepository {

    private SharedPreferences sharedPreferences;

    private final static String DEF_BASE_URL = "https://api.twitter.com/";
    private final static String BASE_URL_KEY = "url_base";
    private final static String TOKEN_TYPE_KEY = "url_base";
    private final static String ACCESS_TOKEN_KEY = "url_base";

    public PreferencesRepositoryImpl(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public String getAppSettings() {
        return sharedPreferences.getString(BASE_URL_KEY, DEF_BASE_URL);
    }

    @Override
    public AuthUser getAuthUser(){
        return new AuthUser(sharedPreferences.getString(TOKEN_TYPE_KEY, ""),
                sharedPreferences.getString(ACCESS_TOKEN_KEY, ""));
    }
}
