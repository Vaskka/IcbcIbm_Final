package com.vaskka.web.iicamp.response;



import java.util.*;

/**
 * @program: FT
 * @description: GetBusinessAllPinGoodOrderResponse 得到商家全部拼单的响应
 * @author: Vaskka
 * @create: 2018/11/23 10:59 PM
 **/

public class GetBusinessAllPinGoodOrderResponse extends BaseResponseInner {

    public static class InnerOrder {

        public InnerOrder(String orderId, String endTime, List<InnerItem> itemList, List<InnerUser> userList) {
            this.orderId = orderId;
            this.endTime = endTime;
            this.itemList = itemList;
            this.userList = userList;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public List<InnerItem> getItemList() {
            return itemList;
        }

        public void setItemList(List<InnerItem> itemList) {
            this.itemList = itemList;
        }

        public List<InnerUser> getUserList() {
            return userList;
        }

        public void setUserList(List<InnerUser> userList) {
            this.userList = userList;
        }

        private String orderId;

        private String endTime;

        public static class InnerItem {

            private String itemId;

            private String itemName;

            private int itemNumber;

            private int itemValue;

            public InnerItem(String itemId, String itemName, int itemNumber, int itemValue) {
                this.itemId = itemId;
                this.itemName = itemName;
                this.itemNumber = itemNumber;
                this.itemValue = itemValue;
            }

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }

            public String getItemName() {
                return itemName;
            }

            public void setItemName(String itemName) {
                this.itemName = itemName;
            }

            public int getItemNumber() {
                return itemNumber;
            }

            public void setItemNumber(int itemNumber) {
                this.itemNumber = itemNumber;
            }

            public int getItemValue() {
                return itemValue;
            }

            public void setItemValue(int itemValue) {
                this.itemValue = itemValue;
            }
        }

        private List<InnerItem> itemList = new ArrayList<>();

        public static class InnerUser {
            private String userId;

            private String userName;

            public InnerUser(String userId, String userName) {
                this.userId = userId;
                this.userName = userName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }
        }

        private List<InnerUser> userList = new ArrayList<>();

    }

    public GetBusinessAllPinGoodOrderResponse(int code, String msg, List<InnerOrder> orderList) {
        super(code, msg);
        this.orderList = orderList;
    }

    private List<InnerOrder> orderList = new ArrayList<>();

    public List<InnerOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<InnerOrder> orderList) {
        this.orderList = orderList;
    }
}
