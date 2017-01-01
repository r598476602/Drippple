package com.mophsic.drippple.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：xiaofei
 * 日期：2017/1/1
 */

public class AuthInterceptor implements Interceptor{
    private String accessToken;

    AuthInterceptor(String accessToken){
        this.accessToken = accessToken;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization", "Bearer " + accessToken)
                .build();
        return chain.proceed(request);
    }
}
