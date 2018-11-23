package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mapping_car_user", schema = "ibm_icbc", catalog = "")
public class MappingCarUserEntity {
    private String carUserMappingId;
    private String mappingPinCarOrderId;
    private String mappingUserId;

    public MappingCarUserEntity(String carUserMappingId, String mappingPinCarOrderId, String mappingUserId) {
        this.carUserMappingId = carUserMappingId;
        this.mappingPinCarOrderId = mappingPinCarOrderId;
        this.mappingUserId = mappingUserId;
    }

    @Id
    @Column(name = "car_user_mapping_id")
    public String getCarUserMappingId() {
        return carUserMappingId;
    }

    public void setCarUserMappingId(String carUserMappingId) {
        this.carUserMappingId = carUserMappingId;
    }

    @Basic
    @Column(name = "mapping_pin_car_order_id")
    public String getMappingPinCarOrderId() {
        return mappingPinCarOrderId;
    }

    public void setMappingPinCarOrderId(String mappingPinCarOrderId) {
        this.mappingPinCarOrderId = mappingPinCarOrderId;
    }

    @Basic
    @Column(name = "mapping_user_id")
    public String getMappingUserId() {
        return mappingUserId;
    }

    public void setMappingUserId(String mappingUserId) {
        this.mappingUserId = mappingUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappingCarUserEntity that = (MappingCarUserEntity) o;
        return Objects.equals(carUserMappingId, that.carUserMappingId) &&
                Objects.equals(mappingPinCarOrderId, that.mappingPinCarOrderId) &&
                Objects.equals(mappingUserId, that.mappingUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carUserMappingId, mappingPinCarOrderId, mappingUserId);
    }
}
