package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.GetBusinessAllItemRequest;
import com.vaskka.web.iicamp.request.LoginRequest;
import com.vaskka.web.iicamp.response.GetBusinessAllItemResponse;
import com.vaskka.web.iicamp.response.GetBusinessAllPinGoodOrderResponse;
import com.vaskka.web.iicamp.response.LoginResponse;
import com.vaskka.web.iicamp.utils.MD5Utils;
import com.vaskka.web.iicamp.utils.Util;
import dao.DAOFactory;
import dao.ItemEntityDao;
import dao.SessionEntityDao;
import dao.UserEntityDao;
import entity.ItemEntity;
import entity.SessionEntity;
import entity.UserEntity;
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
import static com.vaskka.web.iicamp.utils.Util.httpOutput;

/**
 * @program: FT
 * @description: GetBusinessAllItem 得到商家全部的商品
 * @author: Vaskka
 * @create: 2018/11/24 12:52 AM
 **/


@WebServlet(name = "GetBusinessAllItem")
public class GetBusinessAllItem extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetBusinessAllItemRequest req = Util.getBusinessAllItemRequest(request);

        String bid = req.getBusinessId();

        List<GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem> items = new ArrayList<>();

        ItemEntityDao itemEntityDao = DAOFactory.getmInstance().getItemEntityDao(HibernateUtil.getSession());
        java.util.List<ItemEntity> list = itemEntityDao.query("itemFromBusinessId", bid);

        for (ItemEntity ie : list) {
            items.add(new GetBusinessAllPinGoodOrderResponse.InnerOrder.InnerItem(ie.getItemId(), ie.getItemName(), ie.getItemCount(), ie.getItemValue()));
        }

        httpOutput(response, (new Gson()).toJson(new GetBusinessAllItemResponse(0, "success", items)));
    }
}
