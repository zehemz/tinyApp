package com.lucasbais.tinyandroidapp.repository;

import android.util.Base64;

import com.google.gson.Gson;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.client.ApiClient;
import com.lucasbais.tinyandroidapp.dto.AuthUser;

import java.io.IOException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zehemz on 18/01/2017.
 */

@Singleton
public class RestApiClientImpl implements IRestApiClient {

    private final OkHttpClient okHttpClient;
    private final Gson gson;
    private ApiClient apiService;

    @Inject
    public RestApiClientImpl(String baseUrl, Gson gson, OkHttpClient okHttpClient) {
        this.gson = gson;
        this.okHttpClient = okHttpClient;
        setBaseUrl(baseUrl);
    }

    @Override
    public ApiClient getClient() {
        return apiService;
    }

    @Override
    public void setBaseUrl(String baseUrl) throws RuntimeException {
        baseUrl = adaptBaseUrl(baseUrl);

        try {
            apiService = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .build().create(ApiClient.class);
        }
        catch (IllegalArgumentException exception) {
            throw new RuntimeException();
        }
    }

    @Override
    public void regenerateAuthRestClient(AuthUser authUser) {

    }

    private String adaptBaseUrl(String urlBaseRest) {
        if (!urlBaseRest.endsWith("/")) {
            urlBaseRest += "/";
        }
        return urlBaseRest;
    }

}
