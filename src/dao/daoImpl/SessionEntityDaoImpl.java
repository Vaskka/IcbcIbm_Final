package dao.daoImpl;

import dao.SessionEntityDao;
import entity.SessionEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SessionEntityDaoImpl implements SessionEntityDao {

    private final Session session;
    private Transaction transaction;

    public SessionEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(SessionEntity sessionEntity) {
        try {
            transaction = session.beginTransaction();
            session.save(sessionEntity);
            transaction.commit();
            System.out.println("插入成功");
            return sessionEntity.getSessionId();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete SessionEntity as s where s.sessionId=?1";
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
        String hql = "from SessionEntity as s where s." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<SessionEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
