package com.vaskka.web.iicamp.response;

/**
 * @program: FT
 * @description: LoginResponse 登陆返回
 * @author: Vaskka
 * @create: 2018/11/22 10:25 PM
 **/

public class LoginResponse extends BaseResponseInner {


    private String cookie;


    public LoginResponse(int code, String msg, String cookie) {
        super(code, msg);
        this.cookie = cookie;

    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
}
