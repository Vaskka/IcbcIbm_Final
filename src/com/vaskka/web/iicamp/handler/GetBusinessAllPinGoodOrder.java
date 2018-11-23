package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.vaskka.web.iicamp.request.BaseAlreadyLoginRequestInner;
import com.vaskka.web.iicamp.request.GetBusinessAllPinGoodOrderRequest;
import com.vaskka.web.iicamp.request.LoginRequest;
import com.vaskka.web.iicamp.response.GetBusinessAllPinGoodOrderResponse;
import com.vaskka.web.iicamp.response.LoginResponse;
import com.vaskka.web.iicamp.utils.Const;
import com.vaskka.web.iicamp.utils.MD5Utils;
import com.vaskka.web.iicamp.utils.Util;
import dao.*;
import entity.*;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.vaskka.web.iicamp.utils.Util.*;
import static com.vaskka.web.iicamp.utils.Util.httpOutput;

/**
 * @program: FT
 * @description: GetBusinessAllPinGoodOrder 获得某个商家全部的拼单信息
 * @author: Vaskka
 * @create: 2018/11/23 10:50 PM
 **/

public class GetBusinessAllPinGoodOrder extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 思路
     * 在主拼单表查orderId
     * 在两个mapping表构造Inner
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetBusinessAllPinGoodOrderRequest req = getBusinessAllPinGoodOrderRequest(request);

        String bid = req.getBusinessId();

        PinGoodOrderEntityDao pinGoodOrderEntityDao = DAOFactory.getmInstance().getPinGoodOrderEntityDao(HibernateUtil.getSession());

        java.util.List<PinGoodOrderEntity> pinGoodOrderEntityList = pinGoodOrderEntityDao.query("goodFromBusinessId", bid);

        List<GetBusinessAllPinGoodOrderResponse.InnerOrder> innerOrders = new ArrayList<>();
        for (PinGoodOrderEntity entity : pinGoodOrderEntityList) {
            String oid = entity.getGoodOrderId();

            MappingGoodItemEntityDao mappingGoodItemEntityDao = DAOFactory.getmInstance().getMappingGoodItemEntityDao(HibernateUtil.getSession());
            MappingGoodUserEntityDao mappingGoodUserEntityDao = DAOFactory.getmInstance().getMappingGoodUserEntityDao(HibernateUtil.getSession());

            List<MappingGoodItemEntity> listMappingGoodItemEntity = mappingGoodItemEntityDao.query("mappingGoodOrderId", oid);
            List<MappingGoodUserEntity> listMappingGoodUserEntity = mappingGoodUserEntityDao.query("mappingGoodOrderId", oid);

            // 返回结果List

            List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> innerItems = new ArrayList<>();
            List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerUser> innerUsers = new ArrayList<>();


            // 处理innerUsers
            for (MappingGoodUserEntity userEntity : listMappingGoodUserEntity) {
                // 根据uid查userName
                UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());
                String uid = userEntity.getMappingUserId();
                List<UserEntity> listWithOneUser = userEntityDao.query("userId", uid);
                String userName = listWithOneUser.get(0).getUserNickName();

                // 添加查询后的信息
                innerUsers.add(new GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerUser(uid, userName));
            }

            // 处理innerItems
            for (MappingGoodItemEntity itemEntity : listMappingGoodItemEntity) {
                // id name count value
                String iId = itemEntity.getMappingItemId();

                // 在Item表查更多信息
                ItemEntityDao itemEntityDao = DAOFactory.getmInstance().getItemEntityDao(HibernateUtil.getSession());
                List<ItemEntity> itemEntityList = itemEntityDao.query("itemId", iId);

                String iName = itemEntityList.get(0).getItemName();
                int iCount = itemEntityList.get(0).getItemCount();
                int iValue = itemEntityList.get(0).getItemValue();

                innerItems.add(new GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem(iId, iName, iCount, iValue));
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timestampToDate(pinGoodOrderEntityList.get(0).getGoodCreateTime()));
            calendar.add(Calendar.MINUTE, Const.AFTER_MINUATE_OVER);

            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            innerOrders.add(new GetBusinessAllPinGoodOrderResponse.InnerOrder(oid, sf.format(calendar.getTime()), innerItems, innerUsers));

        }

        httpOutput(response, (new Gson()).toJson(new GetBusinessAllPinGoodOrderResponse(0, "success", innerOrders)));



    }
}
