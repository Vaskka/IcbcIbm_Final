package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item", schema = "ibm_icbc", catalog = "")
public class ItemEntity {
    private String itemId;
    private String itemFromBusinessId;
    private int itemValue;
    private String itemImage;
    private String itemName;
    private int itemCount;

    @Id
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "item_from_business_id")
    public String getItemFromBusinessId() {
        return itemFromBusinessId;
    }

    public void setItemFromBusinessId(String itemFromBusinessId) {
        this.itemFromBusinessId = itemFromBusinessId;
    }

    @Basic
    @Column(name = "item_value")
    public int getItemValue() {
        return itemValue;
    }

    public void setItemValue(int itemValue) {
        this.itemValue = itemValue;
    }

    @Basic
    @Column(name = "item_image")
    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    @Basic
    @Column(name = "item_name")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "item_count")
    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemEntity that = (ItemEntity) o;
        return itemValue == that.itemValue &&
                itemCount == that.itemCount &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(itemFromBusinessId, that.itemFromBusinessId) &&
                Objects.equals(itemImage, that.itemImage) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemFromBusinessId, itemValue, itemImage, itemName, itemCount);
    }
}
