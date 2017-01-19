package com.lucasbais.tinyandroidapp.injection.modules;

import android.app.Activity;
import android.content.Context;

import com.lucasbais.tinyandroidapp.injection.name.ActivityScoped;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zehemz on 18/01/2017.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScoped
    Activity provideActivity() {
        return activity;
    }

    @Provides
    @ActivityScoped
    Context provideContext() {
        return activity;
    }
}