package com.mophsic.drippple.network.api;


import com.mophsic.drippple.data.model.AccessToken;


import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface DribbbleAuthService {
    String END_POINT = "https://dribbble.com/";

    @POST("oauth/token")
    Observable<AccessToken> requireToken(@Query("client_id") String clientId,
                                         @Query("client_secret")String clientSecret,
                                         @Query("code") String code);
}
