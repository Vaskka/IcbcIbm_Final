package dao.daoImpl;


import dao.MappingGoodUserEntityDao;
import entity.MappingGoodUserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MappingGoodUserEntityDaoImpl implements MappingGoodUserEntityDao {

    private final Session session;
    private Transaction transaction;

    public MappingGoodUserEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(MappingGoodUserEntity mappingGoodUserEntity){
        try {
            transaction = session.beginTransaction();
            session.save(mappingGoodUserEntity);
            transaction.commit();
            System.out.println("插入成功");
            return mappingGoodUserEntity.getGoodUserMappingId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete MappingGoodUserEntity as m where m.goodUserMappingId=?1";
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
        String hql = "from MappingGoodUserEntity as m where m." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<MappingGoodUserEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
