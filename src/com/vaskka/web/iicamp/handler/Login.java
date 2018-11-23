package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.LoginRequest;
import com.vaskka.web.iicamp.request.VerifyCodeRequest;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import com.vaskka.web.iicamp.response.LoginResponse;
import com.vaskka.web.iicamp.utils.MD5Utils;
import com.vaskka.web.iicamp.utils.Util;
import dao.DAOFactory;
import dao.SessionEntityDao;
import dao.UserEntityDao;
import dao.UserUnregisterEntityDao;
import entity.SessionEntity;
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
 * @description: Login 登陆
 * @author: Vaskka
 * @create: 2018/11/22 10:19 PM
 **/


@WebServlet(name = "Login")
public class Login  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginRequest req = getLoginRequest(request);

        UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());

        List<UserEntity> list = userEntityDao.query("userPhoneNumber", req.getPhoneNumber());


        // 未注册返回失败
        if (list.size() == 0) {
            httpOutput(response, (new Gson()).toJson(new LoginResponse(1, "not register", "error")));
            return;
        }

        SessionEntityDao sessionEntityDao = DAOFactory.getmInstance().getSessionEntityDao(HibernateUtil.getSession());


        // session_token
        String st = MD5Utils.MD5Encode(getNowTime() + getRandInt(), "utf-8");
        sessionEntityDao.insert(new SessionEntity(Util.getRandomId("session"), list.get(0).getUserId(), st));


        httpOutput(response, (new Gson()).toJson(new LoginResponse(0, "success", st)));

    }
}
