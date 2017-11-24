package com.example.ryan.firstapidemo.data.network.services.services;

import com.example.ryan.firstapidemo.model.CakeModel;
import com.example.ryan.firstapidemo.data.network.services.constants.API_List;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Ryan on 22/11/2017.
 */

public interface RequestInterface {

    @GET(API_List.CAKE_LIST_API)
    Observable<List<CakeModel>>getCakesList();
}
