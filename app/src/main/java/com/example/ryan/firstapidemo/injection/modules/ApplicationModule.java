package com.example.ryan.firstapidemo.injection.modules;

import android.app.Application;
import android.content.Context;

import com.example.ryan.firstapidemo.data.AppDataManager;
import com.example.ryan.firstapidemo.data.IDataManager;
import com.example.ryan.firstapidemo.data.network.services.ApiHelper;
import com.example.ryan.firstapidemo.data.network.services.AppApiHelper;
import com.example.ryan.firstapidemo.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ryan on 28/11/2017.
 */

@Module
public class ApplicationModule {

    /**
     * Application Context
     * DataManager
     * ApiHelper
     *
     * Stuff used in application (classes)
     */

    Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context getContext(){
        return application;
    }

    @Provides
    Application getApplication(){
        return application;
    }

    @Provides
    @Singleton
    IDataManager getDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper getApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;
    }
}
