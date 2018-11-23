package dao;

import entity.BusinessEntity;

import java.util.List;

public interface BusinessEntityDao {
    String insert(BusinessEntity businessEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
