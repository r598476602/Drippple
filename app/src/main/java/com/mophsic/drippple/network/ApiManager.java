package com.mophsic.drippple.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mophsic.drippple.network.api.DribbbleService;
import com.mophsic.drippple.network.api.DribbbleAuthService;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 作者：xiaofei
 * 日期：2016/10/16
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class ApiManager {
    private DribbbleService dribbbleApi;
    private DribbbleAuthService dribbbleAuthApi;
    private Retrofit retrofit;

    public static ApiManager getInstance(){
        return ApiManagerHolder.instance;
    }

    private ApiManager(){
        retrofit = new Retrofit
                .Builder()
                .baseUrl(DribbbleService.END_POINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public DribbbleService getDribbbleApi(String token){
        if (dribbbleApi == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor(token))
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();
            dribbbleApi = new Retrofit
                    .Builder()
                    .client(client)
                    .baseUrl(DribbbleService.END_POINT)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(
                            GsonConverterFactory
                                    .create(
                                            new GsonBuilder()
                                                    .setDateFormat(DribbbleService.DATE_FORMAT)
                                                    .create()))
                    .build()
                    .create(DribbbleService.class);
        }
        return dribbbleApi;
    }

    public DribbbleAuthService getDribbbleAuthApi(){
        if (dribbbleAuthApi == null) {
            dribbbleAuthApi = retrofit.create(DribbbleAuthService.class);
        }
        return dribbbleAuthApi;
    }

    private static class ApiManagerHolder{
        private static ApiManager instance = new ApiManager();
    }
}
