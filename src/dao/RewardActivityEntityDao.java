package dao;

import entity.RewardActivityEntity;

import java.util.List;

public interface RewardActivityEntityDao {
    String insert(RewardActivityEntity rewardActivityEntity);
    boolean delete(String id);
    List query(String type, Object value);
}
