package dao;

import dao.daoImpl.*;
import org.hibernate.Session;

public class DAOFactory {
    private static volatile DAOFactory mInstance;
    private DAOFactory(){}

    public static DAOFactory getmInstance(){
        if(mInstance == null){
            synchronized (DAOFactory.class){
                if(mInstance == null) mInstance = new DAOFactory();
            }
        }
        return mInstance;
    }

    public UserUnregisterEntityDao getUserUnregisterEntityDao(Session session){
        return new UserUnregisterEntityDaoImpl(session);
    }

    public SessionEntityDao getSessionEntityDao(Session session){
        return new SessionEntityDaoImpl(session);
    }

    public BusinessEntityDao getBusinessEntityDao(Session session){
        return new BusinessEntityDaoImpl(session);
    }

    public CarRequirementEntityDao getCarRequirementEntityDao(Session session){
        return new CarRequirementEntityDaoImpl(session);
    }

    public ItemEntityDao getItemEntityDao(Session session){
        return new ItemEntityDaoImpl(session);
    }

    public MappingCarPlaceEntityDao getMappingCarPlaceEntityDao(Session session){
        return new MappingCarPlaceEntityDaoImpl(session);
    }

    public MappingCarUserEntityDao getMappingCarUserEntityDao(Session session){
        return new MappingCarUserEntityDaoImpl(session);
    }

    public MappingGoodItemEntityDao getMappingGoodItemEntityDao(Session session){
        return new MappingGoodItemEntityDaoImpl(session);
    }

    public MappingGoodUserEntityDao getMappingGoodUserEntityDao(Session session){
        return new MappingGoodUserEntityDaoImpl(session);
    }

    public PinCarOrderEntityDao getPinCarOrderEntityDao(Session session){
        return new PinCarOrderEntityDaoImpl(session);
    }

    public PinGoodOrderEntityDao getPinGoodOrderEntityDao(Session session){
        return new PinGoodOrderEntityDaoImpl(session);
    }

    public RewardActivityEntityDao getRewardActivityEntityDao(Session session){
        return new RewardActivityEntityDaoImpl(session);
    }

    public UserEntityDao getUserEntityDao(Session session){
        return new UserEntityDaoImpl(session);
    }

    public PlaceEntityDao getPlaceEntityDao(Session session){
        return new PlaceEntityDaoImpl(session);
    }




}
