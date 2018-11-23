package dao;

import entity.MappingCarUserEntity;

import java.util.List;

public interface MappingCarUserEntityDao {
    String insert(MappingCarUserEntity mappingCarUserEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
