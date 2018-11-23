package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.CreateGoodOrderRequest;
import com.vaskka.web.iicamp.response.CreateCarOrderResponse;
import com.vaskka.web.iicamp.response.GetBusinessAllPinGoodOrderResponse;
import com.vaskka.web.iicamp.utils.Util;
import dao.*;
import entity.BusinessEntity;
import entity.MappingGoodItemEntity;
import entity.MappingGoodUserEntity;
import entity.PinGoodOrderEntity;
import org.hibernate.criterion.Order;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Map;

/**
 * @program: FT
 * @description: CreatePinGood 创建新拼单
 * @author: Vaskka
 * @create: 2018/11/24 12:19 AM
 **/
@WebServlet(name = "CreatePinGood")
public class CreatePinGood  extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateGoodOrderRequest req = Util.getCreateGoodOrderRequest(request);

        String bid = req.getBusinessId();
        String oid = Util.getRandomId("good");


        PinGoodOrderEntityDao businessEntityDao = DAOFactory.getmInstance().getPinGoodOrderEntityDao(HibernateUtil.getSession());
        MappingGoodUserEntityDao mappingGoodUserEntityDao = DAOFactory.getmInstance().getMappingGoodUserEntityDao(HibernateUtil.getSession());
        MappingGoodItemEntityDao mappingGoodItemEntityDao = DAOFactory.getmInstance().getMappingGoodItemEntityDao(HibernateUtil.getSession());


        businessEntityDao.insert(new PinGoodOrderEntity(oid, bid, 1, Util.strToSqlDate(Util.getNowTime(), null)));
        mappingGoodUserEntityDao.insert(new MappingGoodUserEntity(Util.getRandomId("mapping-good-user"), oid, req.getUserId()));

        for (GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem item : req.getItemList()) {
            mappingGoodItemEntityDao.insert(new MappingGoodItemEntity(Util.getRandomId("mapping-good-item"), oid, item.getItemId()));
        }

        Util.httpOutput(response, (new Gson()).toJson(new CreateCarOrderResponse(0, "success", oid)));
    }
}
