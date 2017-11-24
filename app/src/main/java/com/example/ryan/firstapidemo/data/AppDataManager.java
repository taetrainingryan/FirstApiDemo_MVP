package com.example.ryan.firstapidemo.data;

import com.example.ryan.firstapidemo.data.network.services.ApiHelper;
import com.example.ryan.firstapidemo.data.network.services.AppApiHelper;
import com.example.ryan.firstapidemo.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Ryan on 24/11/2017.
 */

public class AppDataManager implements IDataManager{

    private ApiHelper apiHelper;

    public AppDataManager() {

        apiHelper = new AppApiHelper();
    }

    @Override
    public Observable<List<CakeModel>> getFromApi_CakeList() {
        return apiHelper.getFromApi_CakeList();
    }
}
