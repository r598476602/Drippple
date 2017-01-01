package com.mophsic.drippple;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

/**
 * 作者：xiaofei
 * 日期：2016/10/15
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        Stetho.initializeWithDefaults(this);
        Logger.init("drippple");
    }
}
