package dao;

import entity.UserEntity;

import java.util.List;

public interface UserEntityDao {
     String insert(UserEntity userEntity);
     boolean delete(String id);
     List query(String type, Object value);
}
