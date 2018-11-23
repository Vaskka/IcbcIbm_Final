package com.vaskka.web.iicamp.request;

import com.vaskka.web.iicamp.response.GetBusinessAllPinGoodOrderResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: FT
 * @description: CreateGoodOrder 生成订单
 * @author: Vaskka
 * @create: 2018/11/24 12:14 AM
 **/

public class CreateGoodOrderRequest extends BaseAlreadyLoginRequestInner {

    private String businessId;

    private java.util.List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList = new ArrayList<>();

    public CreateGoodOrderRequest(String userId, String cookie, String businessId, List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList) {
        super(userId, cookie);
        this.businessId = businessId;
        this.itemList = itemList;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList) {
        this.itemList = itemList;
    }
}
