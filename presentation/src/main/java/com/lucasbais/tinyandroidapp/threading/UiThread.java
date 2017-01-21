package com.lucasbais.tinyandroidapp.threading;

import com.lucasbais.tinyandroidapp.executors.IPostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

@Singleton
public class UiThread implements IPostExecutionThread {

    @Inject
    public UiThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
