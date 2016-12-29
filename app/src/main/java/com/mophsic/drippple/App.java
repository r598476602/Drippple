package com.mophsic.drippple;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * 作者：xiaofei
 * 日期：2016/10/15
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("drippple");
    }
}
