package dao;

import entity.CarRequirementEntity;

import java.util.List;

public interface CarRequirementEntityDao {
    String insert(CarRequirementEntity carRequirementEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
