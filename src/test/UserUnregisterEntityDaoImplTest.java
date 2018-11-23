package test;


import dao.DAOFactory;
import dao.PlaceEntityDao;
import dao.UserUnregisterEntityDao;
import entity.PlaceEntity;
import entity.UserUnregisterEntity;
import org.testng.annotations.Test;
import util.HibernateUtil;

import java.util.List;

public class UserUnregisterEntityDaoImplTest {

    @Test
    public void insert() {
//        BusinessEntity businessEntity=new BusinessEntity();
//        businessEntity.setBusinessCommentValue(1);
//        businessEntity.setBusinessName("hsjdgf");
//        businessEntity.setBusinessPlaceId("dsf");
//        businessEntity.setBusinessSalesVolume(1);
//        businessEntity.setBusinessStartValue(1);
//        businessEntity.setBusinessType(1);
//        Date date=new Date();
//        businessEntity.setBussinessCreateTime(new Timestamp(date.getTime()));
//
//        BusinessEntityDao businessEntityDao= DAOFactory.getmInstance().getBusinessEntityDao(HibernateUtil.getSession());
//        String id=businessEntityDao.insert(businessEntity);
//        System.out.println(id);
        PlaceEntity placeEntity=new PlaceEntity();
        placeEntity.setLatitude(1);
        placeEntity.setLongitude(2);
        placeEntity.setPlaceName("fsdf");


        PlaceEntityDao placeEntityDao=DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
        String id=placeEntityDao.insert(placeEntity);
        System.out.println(id);



        placeEntityDao.update(id,4,3,"fhjdsgf");

    }


    @Test
    public void delete(){
        UserUnregisterEntityDao userUnregisterEntityDao= DAOFactory.getmInstance().getUserUnregisterEntityDao(HibernateUtil.getSession());
        userUnregisterEntityDao.delete("40288a46673179f901673179fd2c0000");
    }

    @Test
    public void query(){
        UserUnregisterEntityDao userUnregisterEntityDao= DAOFactory.getmInstance().getUserUnregisterEntityDao(HibernateUtil.getSession());
        List<UserUnregisterEntity> list=userUnregisterEntityDao.query("userUnregisterBankCard","432754");

        for(UserUnregisterEntity u: list){
            System.out.println(u);
        }
    }


}