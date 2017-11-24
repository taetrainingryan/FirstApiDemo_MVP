package com.example.ryan.firstapidemo.views.cakelist;

import com.example.ryan.firstapidemo.views.ui.base.MvpPresenter;

/**
 * Created by Ryan on 24/11/2017.
 */

public interface ICakeListMvpPresenter<V extends  ICakeListMvpView>   extends MvpPresenter<V>{

    void onCallCakeList();

}
