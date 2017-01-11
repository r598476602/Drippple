package com.mophsic.drippple.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：xiaofei
 * 日期：2017/1/6
 */

public class Images implements Parcelable {

    /**
     * hidpi : null
     * normal : https://d13yacurqjgara.cloudfront.net/users/1/screenshots/471756/sasquatch.png
     * teaser : https://d13yacurqjgara.cloudfront.net/users/1/screenshots/471756/sasquatch_teaser.png
     */

    private String hidpi;
    private String normal;
    private String teaser;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.hidpi);
        dest.writeString(this.normal);
        dest.writeString(this.teaser);
    }

    public Images() {
    }

    protected Images(Parcel in) {
        this.hidpi = in.readString();
        this.normal = in.readString();
        this.teaser = in.readString();
    }

    public String getHidpi() {
        return hidpi;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public void setHidpi(String hidpi) {
        this.hidpi = hidpi;
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel source) {
            return new Images(source);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

}
