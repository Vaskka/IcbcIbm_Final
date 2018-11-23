package dao;

import entity.UserUnregisterEntity;

import java.util.List;

public interface UserUnregisterEntityDao {
     String insert(UserUnregisterEntity userUnregisterEntity);
     boolean delete(String id);
     List query(String type, Object value);
}
