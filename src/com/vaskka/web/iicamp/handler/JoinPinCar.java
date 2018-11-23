package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.CreatePinCarOrderRequest;
import com.vaskka.web.iicamp.request.GetUnregisterUserRequestInner;
import com.vaskka.web.iicamp.request.JoinPinCarRequest;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import com.vaskka.web.iicamp.response.JoinPinCarResponse;
import dao.*;
import entity.*;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.vaskka.web.iicamp.utils.Util.*;

/**
 * @program: FT
 * @description: JoinPinCar 加入某个拼车
 * @author: Vaskka
 * @create: 2018/11/23 11:39 AM
 **/

@WebServlet(name = "JoinPinCar")
public class JoinPinCar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JoinPinCarRequest req = getJoinPinCarRequest(request);

        PinCarOrderEntityDao pinCarOrderEntityDao = DAOFactory.getmInstance().getPinCarOrderEntityDao(HibernateUtil.getSession());
        List<PinCarOrderEntity> list = pinCarOrderEntityDao.query("pinCarOrderId", req.getOrderId());

        if (list.size() == 0) {
            httpOutput(response, (new Gson()).toJson(new BaseResponseInner(1, "order not exist")));
            return;
        }



        // 内部用户集合
        List<JoinPinCarResponse.InnerOrder.InnerUser> innerUsers = new ArrayList<>();


        // 将自己插进去
        MappingCarUserEntityDao mappingCarUserEntityDao = DAOFactory.getmInstance().getMappingCarUserEntityDao(HibernateUtil.getSession());
        mappingCarUserEntityDao.insert(new MappingCarUserEntity(getRandomId("mapping-car-user"), req.getOrderId(), req.getUserId()));


        // 查找用户
        List<MappingCarUserEntity> li = mappingCarUserEntityDao.query("mappingPinCarOrderId", req.getOrderId());

        for (MappingCarUserEntity entity : li) {
            UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());
            List<UserEntity> listWithOne =  userEntityDao.query("userId", entity.getMappingUserId());
            innerUsers.add(new JoinPinCarResponse.InnerOrder.InnerUser(listWithOne.get(0).getUserId(), listWithOne.get(0).getUserNickName()));

        }

        // 查找拼车的地点信息
        String sid = list.get(0).getPinCarOrderStartPlaceId();
        String did = list.get(0).getPinCarOrderDestinationId();

        PlaceEntityDao placeEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
        List<PlaceEntity> sList = placeEntityDao.query("placeId", sid);
        List<PlaceEntity> dList = placeEntityDao.query("placeId", did);


        CreatePinCarOrderRequest.Place sPlace = new CreatePinCarOrderRequest.Place(sList.get(0).getLongitude(), sList.get(0).getLatitude(), sList.get(0).getPlaceName());
        CreatePinCarOrderRequest.Place dPlace = new CreatePinCarOrderRequest.Place(dList.get(0).getLongitude(), dList.get(0).getLatitude(), dList.get(0).getPlaceName());

        int value = list.get(0).getPinCarOrderCurrentValue();


        // 生成返回集合
        JoinPinCarResponse.InnerOrder innerOrder = new JoinPinCarResponse.InnerOrder(list.get(0).getPinCarOrderId(), innerUsers, dPlace, sPlace, value);

        httpOutput(response, (new Gson()).toJson(new JoinPinCarResponse(0, "success", innerOrder)));


    }
}
