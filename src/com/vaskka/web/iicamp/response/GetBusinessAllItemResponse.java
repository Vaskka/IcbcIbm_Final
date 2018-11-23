package com.vaskka.web.iicamp.response;

import java.util.List;
import java.util.ArrayList;

/**
 * @program: FT
 * @description: GetBusinessAllItemResponse 得到商家全部商品返回
 * @author: Vaskka
 * @create: 2018/11/24 12:48 AM
 **/

public class GetBusinessAllItemResponse extends BaseResponseInner {

    List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList = new ArrayList<>();

    public List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList) {
        this.itemList = itemList;
    }

    public GetBusinessAllItemResponse(int code, String msg, List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> itemList) {
        super(code, msg);
        this.itemList = itemList;
    }
}
