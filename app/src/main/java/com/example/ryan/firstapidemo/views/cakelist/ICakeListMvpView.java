package com.example.ryan.firstapidemo.views.cakelist;

import com.example.ryan.firstapidemo.model.CakeModel;
import com.example.ryan.firstapidemo.views.ui.base.MvpView;

import java.util.List;

/**
 * Created by Ryan on 24/11/2017.
 */

public interface ICakeListMvpView extends MvpView{

    void onFetchDataSuccess(List<CakeModel> cakeModels);
    void onFetchDataError(String message);



}
