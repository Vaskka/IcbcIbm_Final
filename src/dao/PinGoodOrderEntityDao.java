package dao;

import entity.PinGoodOrderEntity;

import java.util.List;

public interface PinGoodOrderEntityDao {
    String insert(PinGoodOrderEntity pinGoodOrderEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
