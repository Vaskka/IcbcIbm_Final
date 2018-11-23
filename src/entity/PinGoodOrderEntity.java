package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pin_good_order", schema = "ibm_icbc", catalog = "")
public class PinGoodOrderEntity {
    private String goodOrderId;
    private String goodFromBusinessId;
    private Integer goodStatus;
    private Timestamp goodCreateTime;

    public PinGoodOrderEntity(String goodOrderId, String goodFromBusinessId, Integer goodStatus, Timestamp goodCreateTime) {
        this.goodOrderId = goodOrderId;
        this.goodFromBusinessId = goodFromBusinessId;
        this.goodStatus = goodStatus;
        this.goodCreateTime = goodCreateTime;
    }

    @Id
    @Column(name = "good_order_id")
    public String getGoodOrderId() {
        return goodOrderId;
    }

    public void setGoodOrderId(String goodOrderId) {
        this.goodOrderId = goodOrderId;
    }

    @Basic
    @Column(name = "good_from_business_id")
    public String getGoodFromBusinessId() {
        return goodFromBusinessId;
    }

    public void setGoodFromBusinessId(String goodFromBusinessId) {
        this.goodFromBusinessId = goodFromBusinessId;
    }

    @Basic
    @Column(name = "good_status")
    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    @Basic
    @Column(name = "good_create_time")
    public Timestamp getGoodCreateTime() {
        return goodCreateTime;
    }

    public void setGoodCreateTime(Timestamp goodCreateTime) {
        this.goodCreateTime = goodCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PinGoodOrderEntity that = (PinGoodOrderEntity) o;
        return Objects.equals(goodOrderId, that.goodOrderId) &&
                Objects.equals(goodFromBusinessId, that.goodFromBusinessId) &&
                Objects.equals(goodStatus, that.goodStatus) &&
                Objects.equals(goodCreateTime, that.goodCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodOrderId, goodFromBusinessId, goodStatus, goodCreateTime);
    }
}
