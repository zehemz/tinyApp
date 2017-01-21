package com.lucasbais.tinyandroidapp.repository;

import android.util.Base64;
import com.lucasbais.tinyandroidapp.client.ApiClient;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.dto.TweetList;
import com.lucasbais.tinyandroidapp.executors.IPostExecutionThread;
import com.lucasbais.tinyandroidapp.executors.IThreadExecutor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Single;

/**
 * Created by zehemz on 18/01/2017.
 */

@Singleton
public class TweeterRepositoryImp implements ITweeterRepository {

    private final static String CONSUMER_KEY = "hChLnuFGOmvwpIBtEjrtOjBTt";
    private	final static String CONSUMER_SECRET = "x3ITlibu9ygM0Fa3vHzwwfJ7wN3lJIWnCJxjAHinz5wHBRZ3cK";
    private final static String BEARER_TOKEN_CREDENTIALS = CONSUMER_KEY + ":" + CONSUMER_SECRET;

    private final ApiClient restClient;
    private IPreferencesRepository preferencesRepository;
    private IThreadExecutor threadExecutor;
    private IPostExecutionThread postExecutionThread;

    @Inject
    public TweeterRepositoryImp(IRestApiClient restApiClient,
                                IPreferencesRepository preferencesRepository,
                                IThreadExecutor threadExecutor,
                                IPostExecutionThread postExecutionThread) {

        this.restClient = restApiClient.getClient();
        this.preferencesRepository = preferencesRepository;
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    @Override
    public Single<AuthUser> auth() {

        return restClient.auth(getTwitterAuth(),
                "application/x-www-form-urlencoded;charset=UTF-8",
                "client_credentials")
                .subscribeOn(threadExecutor.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .doOnSuccess(preferencesRepository::setUser);
    }

    @Override
    public Single<TweetList> search(String query) {
        return restClient.query( preferencesRepository.getAuthUser().getAuthUserSignature() ,query)
                .subscribeOn(threadExecutor.getScheduler())
                .observeOn(postExecutionThread.getScheduler());
    }

    private String getTwitterAuth() {
        return "Basic " + getBase64String(BEARER_TOKEN_CREDENTIALS);
    }

    private String getBase64String(String value) {
        try {
            return Base64.encodeToString(value.getBytes("UTF-8"), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
