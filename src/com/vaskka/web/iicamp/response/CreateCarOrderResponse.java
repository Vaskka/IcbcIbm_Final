package com.vaskka.web.iicamp.response;

/**
 * @program: FT
 * @description: CreateCarOrderResponse 创建拼车订单返回
 * @author: Vaskka
 * @create: 2018/11/23 2:13 AM
 **/

public class CreateCarOrderResponse extends BaseResponseInner {

    private String orderId;

    public CreateCarOrderResponse(int code, String msg, String orderId) {
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
