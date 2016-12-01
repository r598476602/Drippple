package com.mophsic.mvp;


import android.support.annotation.UiThread;

/**
 * 作者：xiaofei
 * 日期：2016/10/22
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public interface MPresenter<V extends MView> {

    @UiThread
    void onAttachView(V view);

    @UiThread
    void onDetachView();
}
