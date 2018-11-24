package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "business", schema = "ibm_icbc", catalog = "")
public class BusinessEntity {
    private String businessId;
    private Timestamp bussinessCreateTime;
    private String businessName;
    private int businessType;
    private String businessPlaceId;
    private int businessSalesVolume;
    private int businessStartValue;
    private Integer businessCommentValue;

    public BusinessEntity() {}

    public BusinessEntity(String businessId, Timestamp bussinessCreateTime, String businessName, int businessType, String businessPlaceId, int businessSalesVolume, int businessStartValue, Integer businessCommentValue) {
        this.businessId = businessId;
        this.bussinessCreateTime = bussinessCreateTime;
        this.businessName = businessName;
        this.businessType = businessType;
        this.businessPlaceId = businessPlaceId;
        this.businessSalesVolume = businessSalesVolume;
        this.businessStartValue = businessStartValue;
        this.businessCommentValue = businessCommentValue;
    }

    @Id
    @Column(name = "business_id")
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "bussiness_create_time")
    public Timestamp getBussinessCreateTime() {
        return bussinessCreateTime;
    }

    public void setBussinessCreateTime(Timestamp bussinessCreateTime) {
        this.bussinessCreateTime = bussinessCreateTime;
    }

    @Basic
    @Column(name = "business_name")
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Basic
    @Column(name = "business_type")
    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    @Basic
    @Column(name = "business_place_id")
    public String getBusinessPlaceId() {
        return businessPlaceId;
    }

    public void setBusinessPlaceId(String businessPlaceId) {
        this.businessPlaceId = businessPlaceId;
    }

    @Basic
    @Column(name = "business_sales_volume")
    public int getBusinessSalesVolume() {
        return businessSalesVolume;
    }

    public void setBusinessSalesVolume(int businessSalesVolume) {
        this.businessSalesVolume = businessSalesVolume;
    }

    @Basic
    @Column(name = "business_start_value")
    public int getBusinessStartValue() {
        return businessStartValue;
    }

    public void setBusinessStartValue(int businessStartValue) {
        this.businessStartValue = businessStartValue;
    }

    @Basic
    @Column(name = "business_comment_value")
    public Integer getBusinessCommentValue() {
        return businessCommentValue;
    }

    public void setBusinessCommentValue(Integer businessCommentValue) {
        this.businessCommentValue = businessCommentValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessEntity that = (BusinessEntity) o;
        return businessType == that.businessType &&
                businessSalesVolume == that.businessSalesVolume &&
                businessStartValue == that.businessStartValue &&
                Objects.equals(businessId, that.businessId) &&
                Objects.equals(bussinessCreateTime, that.bussinessCreateTime) &&
                Objects.equals(businessName, that.businessName) &&
                Objects.equals(businessPlaceId, that.businessPlaceId) &&
                Objects.equals(businessCommentValue, that.businessCommentValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessId, bussinessCreateTime, businessName, businessType, businessPlaceId, businessSalesVolume, businessStartValue, businessCommentValue);
    }
}
