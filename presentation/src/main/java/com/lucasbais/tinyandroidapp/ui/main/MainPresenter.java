package com.lucasbais.tinyandroidapp.ui.main;
import android.util.Log;

import com.lucasbais.tinyandroidapp.dto.AuthUser;
import com.lucasbais.tinyandroidapp.dto.TweetList;
import com.lucasbais.tinyandroidapp.interactors.DefaultSubscriber;
import com.lucasbais.tinyandroidapp.repository.ITweeterRepository;
import com.lucasbais.tinyandroidapp.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by zehemz on 18/01/2017.
 */


public class MainPresenter extends BasePresenter<SearchContract.View> implements SearchContract.Actions {

    private ITweeterRepository tweeterRepository;
    private boolean enableToSearch;

    @Inject
    public MainPresenter(ITweeterRepository tweeterRepository) {
        this.tweeterRepository = tweeterRepository;
        enableToSearch = false;
    }

    @Override
    public void attachView(SearchContract.View view) {
        super.attachView(view);
        autenticate();
    }

    private void autenticate() {
        tweeterRepository.auth().subscribe(new DefaultSubscriber<AuthUser>() {
            @Override
            public void onNext(AuthUser next) {
                readyForSearch();
                unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                authError(((HttpException) e).response().code());
                unsubscribe();
            }
        });
    }

    private void readyForSearch() {
        enableToSearch();
        searchOnTwitter("OLX");
    }

    @Override
    public void searchOnTwitter(String s) {
        if(!enableToSearch) return;

        tweeterRepository.search(s).subscribe(new DefaultSubscriber<TweetList>() {
            @Override
            public void onNext(TweetList next) {
                super.onNext(next);
                getView().setTweets(next);
                unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                requestError(((HttpException) e).response().code());
                unsubscribe();
            }
        });
    }

    private void enableToSearch() {
        this.enableToSearch = true;
    }

    private void requestError(int code) {
        Log.e("error", String.valueOf(code));
    }

    private void authError(int code) {
        Log.e("error", String.valueOf(code));
    }
}
