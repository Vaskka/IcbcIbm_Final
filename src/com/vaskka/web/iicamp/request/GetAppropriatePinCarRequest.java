package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: GetAppropriatePinCarRequest 获得可拼车的请求
 * @author: Vaskka
 * @create: 2018/11/23 2:18 AM
 **/

public class GetAppropriatePinCarRequest extends BaseAlreadyLoginRequestInner {


    // 用户要求集合
    private CreatePinCarOrderRequest.UserRequireEntityInner userRequire;

    /**
     * 出发地
     */
    private CreatePinCarOrderRequest.Place startPlace;

    /**
     * 目的地
     */
    private CreatePinCarOrderRequest.Place destinationPlace;


    public CreatePinCarOrderRequest.UserRequireEntityInner getUserRequire() {
        return userRequire;
    }

    public void setUserRequire(CreatePinCarOrderRequest.UserRequireEntityInner userRequire) {
        this.userRequire = userRequire;
    }

    public CreatePinCarOrderRequest.Place getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(CreatePinCarOrderRequest.Place startPlace) {
        this.startPlace = startPlace;
    }

    public CreatePinCarOrderRequest.Place getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(CreatePinCarOrderRequest.Place destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public GetAppropriatePinCarRequest(String userId, String cookie, double longitude, double latitude, CreatePinCarOrderRequest.UserRequireEntityInner userRequire, CreatePinCarOrderRequest.Place startPlace, CreatePinCarOrderRequest.Place destinationPlace) {
        super(userId, cookie);
        this.userRequire = userRequire;
        this.startPlace = startPlace;
        this.destinationPlace = destinationPlace;
    }
}
