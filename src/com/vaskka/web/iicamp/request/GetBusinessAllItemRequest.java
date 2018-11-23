package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: GetBusinessAllItemRequest 得到商家全部的商品
 * @author: Vaskka
 * @create: 2018/11/24 12:44 AM
 **/

public class GetBusinessAllItemRequest extends BaseAlreadyLoginRequestInner {

    private String businessId;

    public GetBusinessAllItemRequest(String userId, String cookie, String businessId) {
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
