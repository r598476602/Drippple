package com.mophsic.drippple.data.model;

/**
 * 作者：xiaofei
 * 日期：2017/1/1
 */

public class AccessToken {
    public final String access_token;
    public final String token_type;
    public final String scope;

    public AccessToken(String access_token, String token_type, String scope) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "access_token:" + access_token +
                "\ntoken_type:" + token_type +
                "\nscope:" + scope;
    }
}
