package com.example.ryan.firstapidemo.injection.components;

import android.app.Application;
import android.content.Context;

import com.example.ryan.firstapidemo.MyApp;
import com.example.ryan.firstapidemo.data.IDataManager;
import com.example.ryan.firstapidemo.data.network.services.ApiHelper;
import com.example.ryan.firstapidemo.injection.modules.ApplicationModule;
import com.example.ryan.firstapidemo.injection.modules.NetworkModule;
import com.example.ryan.firstapidemo.injection.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ryan on 28/11/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(MyApp app);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();

    ApiHelper apiHelper();

}