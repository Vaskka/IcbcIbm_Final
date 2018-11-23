package dao;

import entity.PlaceEntity;

import java.util.List;

public interface PlaceEntityDao {
    String insert(PlaceEntity placeEntity);
    boolean delete(String id);
    List query(String type, Object value);
    boolean update(String id,double longitude,double latitude,String placeName);
}
