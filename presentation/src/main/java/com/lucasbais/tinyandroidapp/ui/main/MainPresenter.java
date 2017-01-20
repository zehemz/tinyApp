package com.lucasbais.tinyandroidapp.ui.main;

import android.util.Log;

import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.interactors.DefaultSubscriber;
import com.lucasbais.tinyandroidapp.repository.ITweeterRepository;

import javax.inject.Inject;

/**
 * Created by zehemz on 18/01/2017.
 */


public class MainPresenter {

    @Inject
    public MainPresenter(ITweeterRepository tweeterRepositoryImp) {

        tweeterRepositoryImp.auth().subscribe(new DefaultSubscriber<AuthUser>(){
            @Override
            public void onNext(AuthUser next) {
                //TODO
                unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                Log.d(e.getMessage().toString(), "eee");
                e.printStackTrace();
                //TODO
            }
        });

    }
}
