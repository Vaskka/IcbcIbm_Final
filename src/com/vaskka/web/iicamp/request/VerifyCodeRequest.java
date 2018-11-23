package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: VerifyCodeRequest 验证码验证Request
 * @author: Vaskka
 * @create: 2018/11/22 3:24 PM
 **/

public class VerifyCodeRequest {

    private String verifyId;

    private String userInputCode;

    public String getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(String verifyId) {
        this.verifyId = verifyId;
    }

    public String getUserInputCode() {
        return userInputCode;
    }

    public void setUserInputCode(String userInputCode) {
        this.userInputCode = userInputCode;
    }

    public VerifyCodeRequest(String verifyId, String userInputCode) {
        this.verifyId = verifyId;
        this.userInputCode = userInputCode;
    }
}
