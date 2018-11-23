package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.GetUnregisterUserRequestInner;
import com.vaskka.web.iicamp.request.VerifyCodeRequest;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import com.vaskka.web.iicamp.utils.Util;
import dao.DAOFactory;
import dao.PlaceEntityDao;
import dao.UserEntityDao;
import dao.UserUnregisterEntityDao;
import entity.PlaceEntity;
import entity.UserEntity;
import entity.UserUnregisterEntity;
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
 * @description: VerifyCode 验证码验证
 * @author: Vaskka
 * @create: 2018/11/22 3:22 PM
 **/
@WebServlet(name = "VerifyCode")
public class VerifyCode extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VerifyCodeRequest inner = getVerifyCodeRequest(request);

        UserUnregisterEntityDao userUnregisterEntityDao = DAOFactory.getmInstance().getUserUnregisterEntityDao(HibernateUtil.getSession());

        List<UserUnregisterEntity> list = userUnregisterEntityDao.query("userUnregisterVerifyId", inner.getVerifyId());

        // 注册地点
        PlaceEntityDao placeEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
        String pid = getRandomId("place");
        placeEntityDao.insert(new PlaceEntity(pid, 0.0d, 0.0d, "blank"));


        // 插入正式用户表
        UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());
        userEntityDao.insert(new UserEntity(getRandomId("user"), list.get(0).getUserUnregisterSex(), list.get(0).getUserUnregisterRealName(), list.get(0).getUserUnregisterNickName(), list.get(0).getUserUnregisterPasswordHash(), list.get(0).getUserUnregisterPhoneNumber(), list.get(0).getUserUnregisterIdCard(),  list.get(0).getUserUnregisterBankCard(), Util.strToSqlDate(getNowTime(), null), pid));


        httpOutput(response, (new Gson()).toJson(new BaseResponseInner(0, "success")));

    }
}
