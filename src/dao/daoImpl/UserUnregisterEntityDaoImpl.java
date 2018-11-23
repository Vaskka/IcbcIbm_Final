package dao.daoImpl;

import dao.UserUnregisterEntityDao;
import entity.UserUnregisterEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserUnregisterEntityDaoImpl implements UserUnregisterEntityDao {

    private final Session session;
    private Transaction transaction;

    public UserUnregisterEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(UserUnregisterEntity userUnregisterEntity) {
        try {
            transaction = session.beginTransaction();
            session.save(userUnregisterEntity);
            transaction.commit();
            System.out.println("插入成功");
            return userUnregisterEntity.getUserUnregisterId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete UserUnregisterEntity as u where u.userUnregisterId=?1";
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
        String hql = "from UserUnregisterEntity as u where u." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<UserUnregisterEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
