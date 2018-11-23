package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: SyncPositionRequest 同步用户信息的请求
 * @author: Vaskka
 * @create: 2018/11/23 12:43 AM
 **/

public class SyncPositionRequest extends BaseAlreadyLoginRequestInner {

    // 经度
    private double longitude;

    // 纬度
    private double latitude;

    // 地点名称
    private String placeName;

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


    public SyncPositionRequest(String userId, String cookie, double longitude, double latitude, String placeName) {
        super(userId, cookie);
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeName = placeName;
    }
}
