package com.example.ryan.firstapidemo.views.cakelist;

import com.example.ryan.firstapidemo.data.IDataManager;
import com.example.ryan.firstapidemo.views.ui.base.BasePresenter;
import com.example.ryan.firstapidemo.views.ui.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Ryan on 24/11/2017.
 */

public class CakeListPresenter <V extends ICakeListMvpView>
        extends BasePresenter<V>
        implements ICakeListMvpPresenter<V>{


    public CakeListPresenter(IDataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onCallCakeList() {

    }
}
