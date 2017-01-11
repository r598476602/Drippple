package com.mophsic.drippple.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：xiaofei
 * 日期：2017/1/6
 */

public class Links implements Parcelable{

    /**
     * web : http://dribbble.com
     * twitter : https://twitter.com/dribbble
     */

    private String web;
    private String twitter;

    public Links(Parcel in) {
    }

    public Links(String web, String twitter) {
        this.web = web;
        this.twitter = twitter;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public static final Creator<Links> CREATOR = new Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
