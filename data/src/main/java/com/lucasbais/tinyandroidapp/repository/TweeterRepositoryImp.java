package com.lucasbais.tinyandroidapp.repository;

import android.util.Log;

import com.lucasbais.tinyandroidapp.client.ApiClient;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.interactors.DefaultSubscriber;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by zehemz on 18/01/2017.
 */

@Singleton
public class TweeterRepositoryImp implements ITweeterRepository {


    private final ApiClient restClient;
    private final IRestApiClient restApiClient;

    @Inject
    public TweeterRepositoryImp(IRestApiClient restApiClient, AuthUser authUser) {
        this.restClient = restApiClient.getClient();
        this.restApiClient = restApiClient;
        auth();
    }

    private void auth() {
        restClient.auth().subscribe(new DefaultSubscriber<AuthUser>(){
            @Override
            public void onNext(AuthUser authUser) {
                    Log.e(authUser.access_token, authUser.token_type);
                    restApiClient.regenerateAuthRestClient(authUser);
            }
        });
    }
}
