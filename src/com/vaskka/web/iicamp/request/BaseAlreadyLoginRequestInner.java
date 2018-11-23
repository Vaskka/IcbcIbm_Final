package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: BaseAlreadyLoginRequestInner 已经登陆的用户的http请求
 * @author: Vaskka
 * @create: 2018/11/21 6:50 PM
 **/

public class BaseAlreadyLoginRequestInner {

    private String userId;

    private String cookie;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public BaseAlreadyLoginRequestInner(String userId, String cookie) {
        this.userId = userId;
        this.cookie = cookie;
    }
}
