package com.lucasbais.tinyandroidapp;

import android.app.Application;
import android.content.Context;

import com.lucasbais.tinyandroidapp.injection.components.ApplicationComponent;


/**
 * Created by zehemz on 18/01/2017.
 */

public class TinyAndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate(){
        super.onCreate();
//        applicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this))
//                .build();
//        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    public static TinyAndroidApplication get(Context context) {
        return (TinyAndroidApplication) context.getApplicationContext();
    }
}
