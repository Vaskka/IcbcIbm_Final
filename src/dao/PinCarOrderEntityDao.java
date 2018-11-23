package dao;

import entity.PinCarOrderEntity;

import java.util.List;

public interface PinCarOrderEntityDao {
    String insert(PinCarOrderEntity pinCarOrderEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
