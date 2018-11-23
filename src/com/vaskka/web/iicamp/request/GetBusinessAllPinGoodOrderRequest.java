package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: GetBusinessAllPinGoodOrderRequest 获取商家全部拼单请求
 * @author: Vaskka
 * @create: 2018/11/23 10:53 PM
 **/

public class GetBusinessAllPinGoodOrderRequest extends BaseAlreadyLoginRequestInner {
    private String businessId;


    public GetBusinessAllPinGoodOrderRequest(String userId, String cookie, String businessId) {
        super(userId, cookie);
        this.businessId = businessId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}
