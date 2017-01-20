package com.lucasbais.tinyandroidapp.repository;

import android.content.SharedPreferences;
import android.util.Log;

import com.lucasbais.tinyandroidapp.dto.AuthUser;

import javax.inject.Inject;

/**
 * Created by zehemz on 18/01/2017.
 */

public class PreferencesRepositoryImpl implements IPreferencesRepository {

    private SharedPreferences sharedPreferences;

    private final static String DEF_BASE_URL = "https://api.twitter.com/";
    private final static String BASE_URL_KEY = "url_base";
    private final static String TOKEN_TYPE_KEY = "url_base";
    private final static String ACCESS_TOKEN_KEY = "url_base";

    @Inject
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

    @Override
    public void setUser(AuthUser authUser) {
        Log.d("USER token_type", authUser.token_type);
        Log.d("USER access_token", authUser.access_token);
    }
}
