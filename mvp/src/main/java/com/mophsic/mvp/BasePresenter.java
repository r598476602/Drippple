package com.mophsic.mvp;

/**
 * 作者：xiaofei
 * 日期：2016/10/22
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public class BasePresenter<V extends MView> implements MPresenter<V>{

    private V view;

    @Override
    public void onAttachView(V view) {
        this.view = view;
    }

    @Override
    public void onDetachView() {
        view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return this.view;
    }
}
