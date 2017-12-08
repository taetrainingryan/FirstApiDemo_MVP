package com.example.ryan.firstapidemo.injection.modules;

import com.example.ryan.firstapidemo.data.network.services.constants.API_List;
import com.example.ryan.firstapidemo.data.network.services.services.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ryan on 28/11/2017.
 */

@Module
public class NetworkModule {

    private static final String NAME_BASE_URL = "NAME_BASE_URL";

    @Provides
    @Named(NAME_BASE_URL)
    String provideBaseUrlString() {
        return API_List.BASE_URL;
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    CallAdapter.Factory provideRXJavaCallAdaptor(){return RxJava2CallAdapterFactory.create();}

    @Provides
    @Singleton
    Retrofit provideRetrofit(Converter.Factory converter, @Named(NAME_BASE_URL) String baseUrl, CallAdapter.Factory callAdaptorFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(converter)
                .addCallAdapterFactory(callAdaptorFactory)
                .baseUrl(baseUrl)
                .build();
    }

    @Provides
    @Singleton
    RequestInterface provideCakeApi(Retrofit retrofit) {
        return retrofit.create(RequestInterface.class);
    }

}
