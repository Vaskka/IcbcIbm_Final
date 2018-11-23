package dao.daoImpl;

import dao.ItemEntityDao;
import entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemEntityDaoImpl implements ItemEntityDao {

    private final Session session;
    private Transaction transaction;

    public ItemEntityDaoImpl(Session session){
        this.session = session;
    }



    @Override
    public String insert(ItemEntity itemEntity) {
        try {
            transaction = session.beginTransaction();
            session.save(itemEntity);
            transaction.commit();
            System.out.println("插入成功");
            return itemEntity.getItemId();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("插入失败");
            return null;
        }
    }

    @Override
    public boolean delete(String id) {
        boolean flag;
        String hql="delete ItemEntity as i where i.itemId=?1";
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
        String hql = "from ItemEntity as i where i." + type + "=?1";
        System.out.println("queryInfo sql " + hql + " value = " + value);
        try{
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(1, value);
            List<ItemEntity> list = query.list();
            transaction.commit();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
