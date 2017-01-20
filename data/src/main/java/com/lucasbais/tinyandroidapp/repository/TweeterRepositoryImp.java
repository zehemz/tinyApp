package com.lucasbais.tinyandroidapp.repository;

import android.util.Base64;
import android.util.Log;

import com.lucasbais.tinyandroidapp.client.ApiClient;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.executors.IPostExecutionThread;
import com.lucasbais.tinyandroidapp.executors.IThreadExecutor;
import com.lucasbais.tinyandroidapp.interactors.DefaultSubscriber;
import com.squareup.okhttp.FormEncodingBuilder;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */

@Singleton
public class TweeterRepositoryImp implements ITweeterRepository {


    private final ApiClient restClient;
    private final IRestApiClient restApiClient;
    private IPreferencesRepository preferencesRepository;
    private IThreadExecutor threadExecutor;
    private IPostExecutionThread postExecutionThread;

    @Inject
    public TweeterRepositoryImp(IRestApiClient restApiClient,
                                IPreferencesRepository preferencesRepository,
                                IThreadExecutor threadExecutor,
                                IPostExecutionThread postExecutionThread) {

        this.restClient = restApiClient.getClient();
        this.restApiClient = restApiClient;
        this.preferencesRepository = preferencesRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public Single<AuthUser> auth() {

        String base64EncodedString =null;

        try {
            String encodedConsumerKey = URLEncoder.encode("hChLnuFGOmvwpIBtEjrtOjBTt","UTF-8");
            String encodedConsumerSecret = URLEncoder.encode("x3ITlibu9ygM0Fa3vHzwwfJ7wN3lJIWnCJxjAHinz5wHBRZ3cK","UTF-8");
            String authString = encodedConsumerKey +":"+encodedConsumerSecret;
            base64EncodedString = Base64.encodeToString(authString.getBytes("UTF-8"), Base64.NO_WRAP);
            base64EncodedString = "Basic " + base64EncodedString;
            client_credentials = FormEncodingBuilder.add("client_credentials", "client_credentials").build();
        } catch (Exception ex) {
        }

        return restClient.auth(client_credentials,
                base64EncodedString,
                "application/x-www-form-urlencoded;charset=UTF-8")
                .subscribeOn(threadExecutor.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .doOnSuccess(preferencesRepository::setUser);
    }
}
