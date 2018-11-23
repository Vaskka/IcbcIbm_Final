package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: JoinPInCarRequest 加入拼单请求
 * @author: Vaskka
 * @create: 2018/11/23 9:57 PM
 **/

public class JoinPinCarRequest extends BaseAlreadyLoginRequestInner {
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public JoinPinCarRequest(String userId, String cookie, String orderId) {
        super(userId, cookie);
        this.orderId = orderId;
    }
}
