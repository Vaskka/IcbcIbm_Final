package dao.daoImpl;

import dao.PlaceEntityDao;
import entity.PlaceEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PlaceEntityDaoImpl implements PlaceEntityDao {

    private final Session session;
    private Transaction transaction;

    public PlaceEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(PlaceEntity placeEntity){
        try {
            transaction = session.beginTransaction();
            session.save(placeEntity);
            transaction.commit();
            System.out.println("插入成功");
            return placeEntity.getPlaceId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete PlaceEntity as p where p.placeId=?1";
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, id);
            query.executeUpdate();
            transaction.commit();
            System.out.println("删除成功");
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除失败");
            flag = false;
        }
        return flag;
    }

    @Override
    public List query(String type, Object value) {
        String hql = "from PlaceEntity as p where p." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<PlaceEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(String id,double longitude,double latitude,String placeName) {
        String hql="update PlaceEntity p set p.longitude=?1, p.latitude=?2 ,p.placeName=?3 where p.placeId=?4";
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, longitude);
            query.setParameter(2, latitude);
            query.setParameter(3, placeName);
            query.setParameter(4, id);
            query.executeUpdate();
            transaction.commit();
            System.out.println("更新成功");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
