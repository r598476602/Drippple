package com.mophsic.mvp;

/**
 * 作者：xiaofei
 * 日期：2016/10/22
 * 邮箱：paozi.xiaofei.123@gmail.com
 */

public interface BaseView<T> extends MView{

    void showContent(T data);

    void showEmpty();
}
