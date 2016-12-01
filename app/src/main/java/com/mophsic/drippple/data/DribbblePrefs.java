package com.mophsic.drippple.data;

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
}
