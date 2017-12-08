package com.example.ryan.firstapidemo.data.network.services;

import com.example.ryan.firstapidemo.data.network.services.services.RequestInterface;
import com.example.ryan.firstapidemo.data.network.services.services.ServerConnection;
import com.example.ryan.firstapidemo.model.CakeModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Ryan on 24/11/2017.
 */

@Singleton
public class AppApiHelper implements ApiHelper{

    RequestInterface requestInterface;

    @Inject
    public AppApiHelper(RequestInterface requestInterface) {
        //requestInterface = ServerConnection.getServerConnection();
        this.requestInterface = requestInterface;
    }

    @Override
    public Observable<List<CakeModel>> getFromApi_CakeList() {
        return requestInterface.getCakesList();
    }

}
