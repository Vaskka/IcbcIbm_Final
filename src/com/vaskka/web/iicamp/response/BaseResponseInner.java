package com.vaskka.web.iicamp.response;

/**
 * @program: FT
 * @description: BaseResponseInner http响应
 * @author: Vaskka
 * @create: 2018/11/21 7:01 PM
 **/

public class BaseResponseInner {
    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponseInner(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
