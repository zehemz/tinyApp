package com.lucasbais.tinyandroidapp.interactors;

import rx.Subscriber;

/**
 * Created by zehemz on 18/01/2017.
 */

public class DefaultSubscriber<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
        // No-op
    }

    @Override
    public void onError(Throwable e) {
        // No-op
    }

    @Override
    public void onNext(T next) {

    }
}

