package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: LoginRequest 登陆请求
 * @author: Vaskka
 * @create: 2018/11/22 10:20 PM
 **/

public class LoginRequest {
    private String phoneNumber;

    private String passwordHash;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LoginRequest(String phoneNumber, String passwordHash) {
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
    }
}
