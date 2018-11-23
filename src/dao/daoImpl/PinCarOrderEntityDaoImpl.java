package dao.daoImpl;

import dao.PinCarOrderEntityDao;
import entity.PinCarOrderEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PinCarOrderEntityDaoImpl implements PinCarOrderEntityDao {

    private final Session session;
    private Transaction transaction;

    public PinCarOrderEntityDaoImpl(Session session){
        this.session = session;
    }


    @Override
    public String insert(PinCarOrderEntity pinCarOrderEntity){
        try {
            transaction = session.beginTransaction();
            session.save(pinCarOrderEntity);
            transaction.commit();
            System.out.println("插入成功");
            return pinCarOrderEntity.getPinCarOrderId();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag ;
        String hql="delete PinCarOrderEntity as p where p.pinCarOrderId=?1";
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
        String hql = "from PinCarOrderEntity as p where p." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<PinCarOrderEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * select *
     * @return List&lt;PinCarOrderEntity&gt;
     */
    public List queryAll() {
        String hql = "from PinCarOrderEntity";
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List<PinCarOrderEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
