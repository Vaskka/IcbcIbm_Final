package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mapping_car_place", schema = "ibm_icbc", catalog = "")
public class MappingCarPlaceEntity {
    private String carPlaceMappingId;
    private String mappingCarOrderId;
    private String mappingPlaceId;

    @Id
    @Column(name = "car_place_mapping_id")
    public String getCarPlaceMappingId() {
        return carPlaceMappingId;
    }

    public void setCarPlaceMappingId(String carPlaceMappingId) {
        this.carPlaceMappingId = carPlaceMappingId;
    }

    @Basic
    @Column(name = "mapping_car_order_id")
    public String getMappingCarOrderId() {
        return mappingCarOrderId;
    }

    public void setMappingCarOrderId(String mappingCarOrderId) {
        this.mappingCarOrderId = mappingCarOrderId;
    }

    @Basic
    @Column(name = "mapping_place_id")
    public String getMappingPlaceId() {
        return mappingPlaceId;
    }

    public void setMappingPlaceId(String mappingPlaceId) {
        this.mappingPlaceId = mappingPlaceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappingCarPlaceEntity that = (MappingCarPlaceEntity) o;
        return Objects.equals(carPlaceMappingId, that.carPlaceMappingId) &&
                Objects.equals(mappingCarOrderId, that.mappingCarOrderId) &&
                Objects.equals(mappingPlaceId, that.mappingPlaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPlaceMappingId, mappingCarOrderId, mappingPlaceId);
    }
}
