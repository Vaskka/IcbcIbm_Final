package dao.daoImpl;

import dao.MappingCarPlaceEntityDao;
import entity.MappingCarPlaceEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MappingCarPlaceEntityDaoImpl implements MappingCarPlaceEntityDao {

    private final Session session;
    private Transaction transaction;

    public MappingCarPlaceEntityDaoImpl(Session session){
        this.session = session;
    }

    @Override
    public String insert(MappingCarPlaceEntity mappingCarPlaceEntity) {
        try {
            transaction = session.beginTransaction();
            session.save(mappingCarPlaceEntity);
            transaction.commit();
            System.out.println("插入成功");
            return mappingCarPlaceEntity.getCarPlaceMappingId();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete MappingCarPlaceEntity as m where m.carPlaceMappingId=?1";
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
        String hql = "from MappingCarPlaceEntity as m where m." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<MappingCarPlaceEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
