package com.example.ryan.firstapidemo.data;

import android.app.Application;
import android.content.Context;

import com.example.ryan.firstapidemo.data.network.services.ApiHelper;
import com.example.ryan.firstapidemo.data.network.services.AppApiHelper;
import com.example.ryan.firstapidemo.injection.scope.ApplicationContext;
import com.example.ryan.firstapidemo.model.CakeModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Ryan on 24/11/2017.
 */

@Singleton
public class AppDataManager implements IDataManager{

    private ApiHelper apiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context application, AppApiHelper appApiHelper) {
        //apiHelper = new AppApiHelper();

        this.apiHelper = appApiHelper;
    }

    @Override
    public Observable<List<CakeModel>> getFromApi_CakeList() {
        return apiHelper.getFromApi_CakeList();
    }
}
