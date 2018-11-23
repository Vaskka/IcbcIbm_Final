package dao;

import entity.ItemEntity;

import java.util.List;

public interface ItemEntityDao {
    String insert(ItemEntity itemEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
