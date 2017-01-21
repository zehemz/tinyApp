package com.lucasbais.tinyandroidapp.injection.components;

import com.lucasbais.tinyandroidapp.TinyAndroidApplication;
import com.lucasbais.tinyandroidapp.executors.IPostExecutionThread;
import com.lucasbais.tinyandroidapp.executors.IThreadExecutor;
import com.lucasbais.tinyandroidapp.injection.modules.ApplicationModule;
import com.lucasbais.tinyandroidapp.repository.IPreferencesRepository;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.repository.ITweeterRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class
})
public interface ApplicationComponent {

    void inject(TinyAndroidApplication tinyAndroidApplication);

    IPreferencesRepository preferencesRepository();

    IThreadExecutor threadExecutor();

    IPostExecutionThread postExecutionThread();

    IRestApiClient restApiClient();

    ITweeterRepository twitterRepository();

}
