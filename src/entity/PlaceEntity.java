package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "place", schema = "ibm_icbc", catalog = "")
public class PlaceEntity {
    private String placeId;
    private double longitude;
    private double latitude;
    private String placeName;


    public PlaceEntity(String placeId, double longitude, double latitude, String placeName) {
        this.placeId = placeId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.placeName = placeName;
    }

    @Id
    @Column(name = "place_id")
    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "place_name")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceEntity that = (PlaceEntity) o;
        return Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                Objects.equals(placeId, that.placeId) &&
                Objects.equals(placeName, that.placeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, longitude, latitude, placeName);
    }
}
