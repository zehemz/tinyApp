package com.lucasbais.tinyandroidapp.ui.base;

public interface Presenter<V extends ViewContract> {

    void attachView(V view);
    void detachView();
}
