package com.example.ryan.firstapidemo;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.ryan.firstapidemo.data.AppDataManager;
import com.example.ryan.firstapidemo.injection.components.ActivityComponent;
import com.example.ryan.firstapidemo.injection.components.ApplicationComponent;
import com.example.ryan.firstapidemo.injection.components.DaggerActivityComponent;
import com.example.ryan.firstapidemo.injection.modules.ActivityModule;
import com.example.ryan.firstapidemo.model.CakeModel;
import com.example.ryan.firstapidemo.data.network.services.services.RequestInterface;
import com.example.ryan.firstapidemo.data.network.services.services.ServerConnection;
import com.example.ryan.firstapidemo.views.cakelist.CakeListPresenter;
import com.example.ryan.firstapidemo.views.cakelist.ICakeListMvpView;
import com.example.ryan.firstapidemo.views.ui.utils.rx.AppSchedulerProvider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import static com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork.LOG_TAG;

public class MainActivity extends AppCompatActivity implements ICakeListMvpView{

    ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    public void setActivityComponent(ActivityComponent activityComponent) {
        this.activityComponent = activityComponent;
    }

    @BindView(R.id.rvCakes) RecyclerView recyclerView;
    @BindView(R.id.swiperefresh) SwipeRefreshLayout swipeRefreshLayout;

      //private RecyclerView recyclerView;
      private List<CakeModel> cakeModels;

      @Inject
      CakeListPresenter<MainActivity> cakeListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDagger();
        ButterKnife.bind(this);

        initRecyclerView();
        initializePresenter();
        getData();

    }

    private void getData() {

        cakeListPresenter.onCallCakeList();
    }

    public void injectDagger(){
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApp)getApplicationContext()).getApplicationComponent())
                .build();

        activityComponent.inject(this);
    }

    public void initializePresenter(){

        //cakeListPresenter = new CakeListPresenter<>(new AppDataManager(), new AppSchedulerProvider(), new CompositeDisposable());
        cakeListPresenter.onAttach(this);

    }

    public void initRecyclerView(){

        //recyclerView = (RecyclerView) findViewById(R.id.rvCakes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i(LOG_TAG, "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.

                        cakeListPresenter.onCallCakeList();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
        );

    }

    @Override
    public void onFetchDataSuccess(List<CakeModel> cakeModels) {

        recyclerView.setAdapter(new CakesAdapter(cakeModels, R.layout.row, getApplicationContext()));

    }

    @Override
    public void onFetchDataError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
