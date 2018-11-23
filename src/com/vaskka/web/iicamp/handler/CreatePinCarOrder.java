package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.CreatePinCarOrderRequest;
import com.vaskka.web.iicamp.request.GetUnregisterUserRequestInner;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import com.vaskka.web.iicamp.response.CreateCarOrderResponse;
import dao.*;
import entity.*;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.vaskka.web.iicamp.utils.Util.*;

/**
 * @program: FT
 * @description: CreatePinCarOrder 创建拼车订单
 * @author: Vaskka
 * @create: 2018/11/23 1:14 AM
 **/



@WebServlet(name = "CreatePinCarOrder")
public class CreatePinCarOrder extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreatePinCarOrderRequest req = getCreatePinCarOrderRequest(request);

        //* 暂时不检查session *//


        CarRequirementEntityDao carRequirementEntityDao = DAOFactory.getmInstance().getCarRequirementEntityDao(HibernateUtil.getSession());

        List<CarRequirementEntity> list = carRequirementEntityDao.query("carRequirementUserId", req.getUserId());

        // 处理用户要求
        // 不存在则创建
        if (list.size() == 0) {
            carRequirementEntityDao.insert(new CarRequirementEntity(getRandomId("car-require"), req.getUserId(), req.getUserRequire().getDriverSex(), req.getUserRequire().getPassengerSex(), req.getUserRequire().getMaxPassengerNumber()));

        }
        else {
            // 存在则更新（先删在插）
            carRequirementEntityDao.delete(list.get(0).getCarRequirementId());
            carRequirementEntityDao.insert(new CarRequirementEntity(list.get(0).getCarRequirementId(), list.get(0).getCarRequirementUserId(), req.getUserRequire().getDriverSex(), req.getUserRequire().getPassengerSex(), req.getUserRequire().getMaxPassengerNumber()));

        }

        // 处理目的地出发地
        PlaceEntityDao placeEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
        String startPlaceId = getRandomId("place");
        String destinationId = getRandomId("place");
        placeEntityDao.insert(new PlaceEntity(startPlaceId, req.getStartPlace().getLongitude(), req.getStartPlace().getLatitude(), req.getStartPlace().getPlaceName()));
        placeEntityDao.insert(new PlaceEntity(destinationId, req.getDestinationPlace().getLongitude(), req.getDestinationPlace().getLatitude(), req.getDestinationPlace().getPlaceName()));

        // 处理金额
        int value = 1500;

        // 订单主键
        String oid = getRandomId("pin-car");

        PinCarOrderEntityDao pinCarOrderEntityDao = DAOFactory.getmInstance().getPinCarOrderEntityDao(HibernateUtil.getSession());
        pinCarOrderEntityDao.insert(new PinCarOrderEntity(oid, startPlaceId, destinationId, value, strToSqlDate(getNowTime(), null), 1));

        // 注册拼车与用户映射
        MappingCarUserEntityDao mappingCarUserEntityDao = DAOFactory.getmInstance().getMappingCarUserEntityDao(HibernateUtil.getSession());
        mappingCarUserEntityDao.insert(new MappingCarUserEntity(getRandomId("mapping-car-user"), oid, req.getUserId()));

        httpOutput(response, (new Gson()).toJson(new CreateCarOrderResponse(0, "success", oid)));
    }





}
