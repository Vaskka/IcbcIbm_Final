package com.vaskka.web.iicamp.response;

/**
 * @program: FT
 * @description: CreatePinGoodResponse 创建拼单返回
 * @author: Vaskka
 * @create: 2018/11/24 12:18 AM
 **/

public class CreatePinGoodResponse extends  BaseResponseInner {

    private String orderId;

    public CreatePinGoodResponse(int code, String msg, String orderId) {
        super(code, msg);
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
