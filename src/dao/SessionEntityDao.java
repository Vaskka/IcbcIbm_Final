package dao;

import entity.SessionEntity;

import java.util.List;

public interface SessionEntityDao {
    String insert(SessionEntity sessionEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
