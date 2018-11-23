package dao;

import entity.MappingGoodUserEntity;

import java.util.List;

public interface MappingGoodUserEntityDao {
    String insert(MappingGoodUserEntity mappingGoodUserEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
