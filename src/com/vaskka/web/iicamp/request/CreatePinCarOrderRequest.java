package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: CreatePinCarOrderRequest 创建拼车订单
 * @author: Vaskka
 * @create: 2018/11/23 1:16 AM
 **/

public class CreatePinCarOrderRequest extends BaseAlreadyLoginRequestInner {


    /**
     * 地点类
     */
    public static  class Place {
        // 经度
        private double longitude;

        // 纬度
        private double latitude;

        // 地点名称
        private String placeName;

        public Place(double longitude, double latitude, String placeName) {
            this.longitude = longitude;
            this.latitude = latitude;
            this.placeName = placeName;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }
    }

    /**
     * 出发地
     */
    private Place startPlace;

    /**
     * 目的地
     */
    private Place destinationPlace;

    /**
     * 用户要求类
     */
    public class UserRequireEntityInner {
        private int driverSex;

        private int passengerSex;

        private int maxPassengerNumber;


        public UserRequireEntityInner(int driverSex, int passengerSex, int maxPassengerNumber) {
            this.driverSex = driverSex;
            this.passengerSex = passengerSex;
            this.maxPassengerNumber = maxPassengerNumber;
        }

        public int getDriverSex() {
            return driverSex;
        }

        public void setDriverSex(int driverSex) {
            this.driverSex = driverSex;
        }

        public int getPassengerSex() {
            return passengerSex;
        }

        public void setPassengerSex(int passengerSex) {
            this.passengerSex = passengerSex;
        }

        public int getMaxPassengerNumber() {
            return maxPassengerNumber;
        }

        public void setMaxPassengerNumber(int maxPassengerNumber) {
            this.maxPassengerNumber = maxPassengerNumber;
        }

    }

    private UserRequireEntityInner userRequire;

    public UserRequireEntityInner getUserRequire() {
        return userRequire;
    }

    public void setUserRequire(UserRequireEntityInner userRequire) {
        this.userRequire = userRequire;
    }

    public Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Place startPlace) {
        this.startPlace = startPlace;
    }

    public Place getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(Place destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public CreatePinCarOrderRequest(String userId, String cookie, Place startPlace, Place destinationPlace, UserRequireEntityInner userRequire) {
        super(userId, cookie);
        this.startPlace = startPlace;
        this.destinationPlace = destinationPlace;
        this.userRequire = userRequire;
    }
}
