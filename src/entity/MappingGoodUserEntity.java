package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mapping_good_user", schema = "ibm_icbc", catalog = "")
public class MappingGoodUserEntity {
    private String goodUserMappingId;
    private String mappingGoodOrderId;
    private String mappingUserId;

    public MappingGoodUserEntity(String goodUserMappingId, String mappingGoodOrderId, String mappingUserId) {
        this.goodUserMappingId = goodUserMappingId;
        this.mappingGoodOrderId = mappingGoodOrderId;
        this.mappingUserId = mappingUserId;
    }

    @Id
    @Column(name = "good_user_mapping_id")
    public String getGoodUserMappingId() {
        return goodUserMappingId;
    }

    public void setGoodUserMappingId(String goodUserMappingId) {
        this.goodUserMappingId = goodUserMappingId;
    }

    @Basic
    @Column(name = "mapping_good_order_id")
    public String getMappingGoodOrderId() {
        return mappingGoodOrderId;
    }

    public void setMappingGoodOrderId(String mappingGoodOrderId) {
        this.mappingGoodOrderId = mappingGoodOrderId;
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
        MappingGoodUserEntity that = (MappingGoodUserEntity) o;
        return Objects.equals(goodUserMappingId, that.goodUserMappingId) &&
                Objects.equals(mappingGoodOrderId, that.mappingGoodOrderId) &&
                Objects.equals(mappingUserId, that.mappingUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodUserMappingId, mappingGoodOrderId, mappingUserId);
    }
}
