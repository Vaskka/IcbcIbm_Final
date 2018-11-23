package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pin_car_order", schema = "ibm_icbc", catalog = "")
public class PinCarOrderEntity {
    private String pinCarOrderId;
    private String pinCarOrderStartPlaceId;
    private String pinCarOrderDestinationId;
    private int pinCarOrderCurrentValue;
    private Timestamp pinCarOrderCreateTime;
    private int pinCarOrderStatus;

    public PinCarOrderEntity(String pinCarOrderId, String pinCarOrderStartPlaceId, String pinCarOrderDestinationId, int pinCarOrderCurrentValue, Timestamp pinCarOrderCreateTime, int pinCarOrderStatus) {
        this.pinCarOrderId = pinCarOrderId;
        this.pinCarOrderStartPlaceId = pinCarOrderStartPlaceId;
        this.pinCarOrderDestinationId = pinCarOrderDestinationId;
        this.pinCarOrderCurrentValue = pinCarOrderCurrentValue;
        this.pinCarOrderCreateTime = pinCarOrderCreateTime;
        this.pinCarOrderStatus = pinCarOrderStatus;
    }

    @Id
    @Column(name = "pin_car_order_id")
    public String getPinCarOrderId() {
        return pinCarOrderId;
    }

    public void setPinCarOrderId(String pinCarOrderId) {
        this.pinCarOrderId = pinCarOrderId;
    }

    @Basic
    @Column(name = "pin_car_order_start_place_id")
    public String getPinCarOrderStartPlaceId() {
        return pinCarOrderStartPlaceId;
    }

    public void setPinCarOrderStartPlaceId(String pinCarOrderStartPlaceId) {
        this.pinCarOrderStartPlaceId = pinCarOrderStartPlaceId;
    }

    @Basic
    @Column(name = "pin_car_order_destination_id")
    public String getPinCarOrderDestinationId() {
        return pinCarOrderDestinationId;
    }

    public void setPinCarOrderDestinationId(String pinCarOrderDestinationId) {
        this.pinCarOrderDestinationId = pinCarOrderDestinationId;
    }

    @Basic
    @Column(name = "pin_car_order_current_value")
    public int getPinCarOrderCurrentValue() {
        return pinCarOrderCurrentValue;
    }

    public void setPinCarOrderCurrentValue(int pinCarOrderCurrentValue) {
        this.pinCarOrderCurrentValue = pinCarOrderCurrentValue;
    }

    @Basic
    @Column(name = "pin_car_order_create_time")
    public Timestamp getPinCarOrderCreateTime() {
        return pinCarOrderCreateTime;
    }

    public void setPinCarOrderCreateTime(Timestamp pinCarOrderCreateTime) {
        this.pinCarOrderCreateTime = pinCarOrderCreateTime;
    }

    @Basic
    @Column(name = "pin_car_order_status")
    public int getPinCarOrderStatus() {
        return pinCarOrderStatus;
    }

    public void setPinCarOrderStatus(int pinCarOrderStatus) {
        this.pinCarOrderStatus = pinCarOrderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinCarOrderEntity that = (PinCarOrderEntity) o;
        return pinCarOrderCurrentValue == that.pinCarOrderCurrentValue &&
                pinCarOrderStatus == that.pinCarOrderStatus &&
                Objects.equals(pinCarOrderId, that.pinCarOrderId) &&
                Objects.equals(pinCarOrderStartPlaceId, that.pinCarOrderStartPlaceId) &&
                Objects.equals(pinCarOrderDestinationId, that.pinCarOrderDestinationId) &&
                Objects.equals(pinCarOrderCreateTime, that.pinCarOrderCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinCarOrderId, pinCarOrderStartPlaceId, pinCarOrderDestinationId, pinCarOrderCurrentValue, pinCarOrderCreateTime, pinCarOrderStatus);
    }
}
