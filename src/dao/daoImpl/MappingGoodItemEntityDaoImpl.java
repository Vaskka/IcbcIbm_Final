package dao.daoImpl;

import dao.MappingGoodItemEntityDao;
import entity.MappingGoodItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MappingGoodItemEntityDaoImpl implements MappingGoodItemEntityDao {

    private final Session session;
    private Transaction transaction;

    public MappingGoodItemEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(MappingGoodItemEntity mappingGoodItemEntity){
        try {
            transaction = session.beginTransaction();
            session.save(mappingGoodItemEntity);
            transaction.commit();
            System.out.println("插入成功");
            return mappingGoodItemEntity.getGoodItemMappingId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete MappingGoodItemEntity as m where m.goodItemMappingId=?1";
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
        String hql = "from MappingGoodItemEntity as m where m." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<MappingGoodItemEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
