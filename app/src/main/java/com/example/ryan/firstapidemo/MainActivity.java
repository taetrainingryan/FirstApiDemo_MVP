package com.example.ryan.firstapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.ryan.firstapidemo.model.CakeModel;
import com.example.ryan.firstapidemo.data.network.services.services.RequestInterface;
import com.example.ryan.firstapidemo.data.network.services.services.ServerConnection;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

//    private RequestInterface requestInterface;
//    private RecyclerView recyclerView;
//    private List<CakeModel> cakeModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        recyclerView = (RecyclerView) findViewById(R.id.rvCakes) ;
//
//        requestInterface = ServerConnection.getServerConnection();
//        requestInterface.getCakesList()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<List<CakeModel>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<CakeModel> value) {
//
//                        cakeModels = value;
//
//                        for(CakeModel c:value){
//                            Log.i("CakeList" , c.getTitle());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                        initializeRecyclerView();
//
//                    }
//                });

    }

    private void initializeRecyclerView() {

        recyclerView=(RecyclerView) findViewById(R.id.rvCakes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new CakesAdapter(cakeModels, R.layout.row, getApplicationContext()));

    }
}
