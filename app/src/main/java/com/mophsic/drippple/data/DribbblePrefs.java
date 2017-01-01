package com.mophsic.drippple.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.mophsic.drippple.BuildConfig;

/**
 * 作者：xiaofei
 * 日期：2016/10/22
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class DribbblePrefs {
    public static final String LOGIN_URL = "https://dribbble.com/oauth/authorize?client_id="
            + BuildConfig.DRIBBBLE_CLIENT_ID
            + "&redirect_uri=drippple%3A%2F%2Fdrippple-callback"
            + "&scope=public+write+comment+upload";

    private final String PREFS_NAME = "drippple_prefs";
    private final String KEY_ACCESS_TOKEN = "ACCESS_TOKEN";

    private String accessToken;
    private SharedPreferences prefs;

    private static DribbblePrefs instance;

    private DribbblePrefs(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        accessToken = prefs.getString(KEY_ACCESS_TOKEN, "");
    }

    public static DribbblePrefs get(Context context){
        if (instance == null) {
            synchronized (DribbblePrefs.class) {
                if (instance == null) {
                    instance = new DribbblePrefs(context);
                }
            }
        }
        return instance;
    }

    public void setToken(String token){
        if (!TextUtils.isEmpty(token)) {
            prefs.edit().putString(KEY_ACCESS_TOKEN, token).apply();
        }
    }

    public String getToken(){
        return TextUtils.isEmpty(accessToken) ?
                BuildConfig.DRIBBBLE_ACCESS_TOKEN : accessToken;
    }
}
