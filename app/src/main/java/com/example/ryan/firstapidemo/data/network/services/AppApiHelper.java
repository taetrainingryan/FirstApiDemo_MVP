package com.example.ryan.firstapidemo.data.network.services;

import com.example.ryan.firstapidemo.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Ryan on 24/11/2017.
 */

public class AppApiHelper implements ApiHelper{

    @Override
    public Observable<List<CakeModel>> getFromApi_CakeList() {
        return null;
    }
    
}
