package com.example.ryan.firstapidemo.data.network.services;

import com.example.ryan.firstapidemo.model.CakeModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Ryan on 24/11/2017.
 */

public interface ApiHelper {

    Observable<List<CakeModel>> getFromApi_CakeList();

}
