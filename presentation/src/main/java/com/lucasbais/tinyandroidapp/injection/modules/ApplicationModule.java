package com.lucasbais.tinyandroidapp.injection.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lucasbais.tinyandroidapp.executors.IPostExecutionThread;
import com.lucasbais.tinyandroidapp.executors.IThreadExecutor;
import com.lucasbais.tinyandroidapp.executors.JobExecutor;
import com.lucasbais.tinyandroidapp.injection.name.BaseUrl;
import com.lucasbais.tinyandroidapp.repository.IPreferencesRepository;
import com.lucasbais.tinyandroidapp.client.IRestApiClient;
import com.lucasbais.tinyandroidapp.repository.ITweeterRepository;
import com.lucasbais.tinyandroidapp.repository.PreferencesRepositoryImpl;
import com.lucasbais.tinyandroidapp.repository.RestApiClientImpl;
import com.lucasbais.tinyandroidapp.repository.TweeterRepositoryImp;
import com.lucasbais.tinyandroidapp.threading.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(final Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    public IThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public IPostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public ITweeterRepository provideTwitterRepository(final IRestApiClient restApiClient) {
        return new TweeterRepositoryImp(restApiClient, null); // TODO
    }

    @Provides
    @Singleton
    public IRestApiClient provideRestApiClient(@BaseUrl String baseUrl, Gson gson, OkHttpClient okHttpClient) {
        return new RestApiClientImpl(baseUrl, gson, okHttpClient);
    }

    @Provides
    @Singleton
    public IPreferencesRepository providePreferences(final SharedPreferences sharedPreferences) {
        return new PreferencesRepositoryImpl(sharedPreferences);
    }

    @Provides
    @BaseUrl
    public String provideBaseUrl(IPreferencesRepository preferencesRepository) {
        return preferencesRepository.getAppSettings();
    }
}

