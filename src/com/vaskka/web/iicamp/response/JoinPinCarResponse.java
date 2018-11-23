package com.vaskka.web.iicamp.response;


import com.vaskka.web.iicamp.request.CreatePinCarOrderRequest;

import java.util.List;

import java.util.ArrayList;

/**
 * @program: FT
 * @description: JoinPinCarResponse 加入拼车返回
 * @author: Vaskka
 * @create: 2018/11/23 10:17 PM
 **/

public class JoinPinCarResponse extends BaseResponseInner {

    public JoinPinCarResponse(int code, String msg, InnerOrder order) {
        super(code, msg);
        this.order = order;
    }

    public static class InnerOrder {

        private String orderId;

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


        private List<InnerUser> passengerList = new ArrayList<>();


        private CreatePinCarOrderRequest.Place destinationPlace;

        private CreatePinCarOrderRequest.Place startPlace;

        private int value;

        public InnerOrder(String orderId, List<InnerUser> passengerList, CreatePinCarOrderRequest.Place destinationPlace, CreatePinCarOrderRequest.Place startPlace, int value) {
            this.orderId = orderId;
            this.passengerList = passengerList;
            this.destinationPlace = destinationPlace;
            this.startPlace = startPlace;
            this.value = value;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public List<InnerUser> getPassengerList() {
            return passengerList;
        }

        public void setPassengerList(List<InnerUser> passengerList) {
            this.passengerList = passengerList;
        }

        public CreatePinCarOrderRequest.Place getDestinationPlace() {
            return destinationPlace;
        }

        public void setDestinationPlace(CreatePinCarOrderRequest.Place destinationPlace) {
            this.destinationPlace = destinationPlace;
        }

        public CreatePinCarOrderRequest.Place getStartPlace() {
            return startPlace;
        }

        public void setStartPlace(CreatePinCarOrderRequest.Place startPlace) {
            this.startPlace = startPlace;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private InnerOrder order;

    public InnerOrder getOrder() {
        return order;
    }

    public void setOrder(InnerOrder order) {
        this.order = order;
    }
}
