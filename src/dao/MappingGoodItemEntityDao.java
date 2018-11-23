package dao;

import entity.MappingGoodItemEntity;

import java.util.List;

public interface MappingGoodItemEntityDao {
    String insert(MappingGoodItemEntity mappingGoodItemEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
