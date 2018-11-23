package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mapping_good_item", schema = "ibm_icbc", catalog = "")
public class MappingGoodItemEntity {
    private String goodItemMappingId;
    private String mappingGoodOrderId;
    private String mappingItemId;

    public MappingGoodItemEntity(String goodItemMappingId, String mappingGoodOrderId, String mappingItemId) {
        this.goodItemMappingId = goodItemMappingId;
        this.mappingGoodOrderId = mappingGoodOrderId;
        this.mappingItemId = mappingItemId;
    }

    @Id
    @Column(name = "good_item_mapping_id")
    public String getGoodItemMappingId() {
        return goodItemMappingId;
    }

    public void setGoodItemMappingId(String goodItemMappingId) {
        this.goodItemMappingId = goodItemMappingId;
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
    @Column(name = "mapping_item_id")
    public String getMappingItemId() {
        return mappingItemId;
    }

    public void setMappingItemId(String mappingItemId) {
        this.mappingItemId = mappingItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MappingGoodItemEntity that = (MappingGoodItemEntity) o;
        return Objects.equals(goodItemMappingId, that.goodItemMappingId) &&
                Objects.equals(mappingGoodOrderId, that.mappingGoodOrderId) &&
                Objects.equals(mappingItemId, that.mappingItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodItemMappingId, mappingGoodOrderId, mappingItemId);
    }
}
