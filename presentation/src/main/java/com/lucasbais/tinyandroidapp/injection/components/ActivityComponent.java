package com.lucasbais.tinyandroidapp.injection.components;

import android.content.Context;

import com.lucasbais.tinyandroidapp.injection.modules.ActivityModule;
import com.lucasbais.tinyandroidapp.injection.name.ActivityScoped;
import com.lucasbais.tinyandroidapp.ui.main.SearchFragmentActivity;

import dagger.Component;

/**
 * Created by zehemz on 18/01/2017.
 */

@ActivityScoped
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SearchFragmentActivity activity);

    Context context();
}