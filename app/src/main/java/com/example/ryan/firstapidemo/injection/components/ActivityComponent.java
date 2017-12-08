package com.example.ryan.firstapidemo.injection.components;

import com.example.ryan.firstapidemo.MainActivity;
import com.example.ryan.firstapidemo.injection.modules.ActivityModule;
import com.example.ryan.firstapidemo.injection.scope.ActivityContext;
import com.example.ryan.firstapidemo.injection.scope.PerActivity;

import dagger.Component;

/**
 * Created by Ryan on 28/11/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);

}
