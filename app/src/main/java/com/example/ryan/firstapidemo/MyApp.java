package com.example.ryan.firstapidemo;

import android.app.Application;

import com.example.ryan.firstapidemo.injection.components.ApplicationComponent;
import com.example.ryan.firstapidemo.injection.components.DaggerApplicationComponent;
import com.example.ryan.firstapidemo.injection.modules.ApplicationModule;

/**
 * Created by Ryan on 28/11/2017.
 */

public class MyApp extends Application {

    ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
