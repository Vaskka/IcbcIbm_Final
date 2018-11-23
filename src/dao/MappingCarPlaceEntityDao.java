package dao;

import entity.MappingCarPlaceEntity;

import java.util.List;

public interface MappingCarPlaceEntityDao {
    String insert(MappingCarPlaceEntity mappingCarPlaceEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
