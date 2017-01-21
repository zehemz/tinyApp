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
    private String lastSearch;

    @Inject
    public MainPresenter(ITweeterRepository tweeterRepository) {
        this.tweeterRepository = tweeterRepository;
        enableToSearch = false;
        lastSearch = "";
    }

    @Override
    public void attachView(SearchContract.View view) {
        super.attachView(view);
        autenticate();
    }

    private void autenticate() {

        getView().showLoading(true);

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
    public void searchOnTwitter(String newSearch) {

        if (!enableToSearch || lastSearch.equals(newSearch)) return;

        lastSearch = newSearch;

        tweeterRepository.search(newSearch).subscribe(new DefaultSubscriber<TweetList>() {
            @Override
            public void onNext(TweetList next) {
                super.onNext(next);
                manageSearchResult(next);
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

    private void manageSearchResult(TweetList next) {
        getView().setTweets(next);
        getView().showLoading(false);
    }

    private void enableToSearch() {
        this.enableToSearch = true;
    }

    private void requestError(int code) {
        Log.e("error", String.valueOf(code));
        getView().showLoading(false);
    }

    private void authError(int code) {
        Log.e("error", String.valueOf(code));
        getView().showLoading(false);
    }
}
