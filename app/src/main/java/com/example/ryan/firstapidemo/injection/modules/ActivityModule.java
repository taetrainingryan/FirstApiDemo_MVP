package com.example.ryan.firstapidemo.injection.modules;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.ryan.firstapidemo.injection.scope.ActivityContext;
import com.example.ryan.firstapidemo.views.cakelist.CakeListPresenter;
import com.example.ryan.firstapidemo.views.cakelist.ICakeListMvpPresenter;
import com.example.ryan.firstapidemo.views.cakelist.ICakeListMvpView;
import com.example.ryan.firstapidemo.views.ui.utils.rx.AppSchedulerProvider;
import com.example.ryan.firstapidemo.views.ui.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ryan on 28/11/2017.
 */

@Module
public class ActivityModule {

    /**
     * Activity
     * Presenter
     * Scheduler
     * Disposable
     *
     * Stuff used in views.
     */

    AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    @ActivityContext
    Context getActivityContext(){
        return appCompatActivity;
    }

    @Provides
    AppCompatActivity getAppCompatActivity(){
        return appCompatActivity;
    }

    @Provides
    SchedulerProvider getAppSchedulerProvider(){
        return new AppSchedulerProvider();
    }

    @Provides
    CompositeDisposable getCompositeDisposable(){
        return new CompositeDisposable();
    }

    @Provides
    ICakeListMvpPresenter<ICakeListMvpView> getCakeListPresenter(CakeListPresenter<ICakeListMvpView> cakeListMvpViewCakeListPresenter){
        return cakeListMvpViewCakeListPresenter;
    }
}
