package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import com.vaskka.web.iicamp.request.GetUnregisterUserRequestInner;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import dao.DAOFactory;
import dao.UserEntityDao;
import dao.UserUnregisterEntityDao;
import entity.UserEntity;
import entity.UserUnregisterEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import static com.vaskka.web.iicamp.utils.Util.getUnregisterUserRequestInner;
import static com.vaskka.web.iicamp.utils.Util.httpOutput;

/**
 * @program: FT
 * @description: GetUnregisterUser 成为未注册用户
 * @author: Vaskka
 * @create: 2018/11/21 6:31 PM
 **/

@WebServlet(name = "GetUnregisterUser")
public class GetUnregisterUser extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetUnregisterUserRequestInner inner = getUnregisterUserRequestInner(request);

        UserUnregisterEntityDao userUnregisterEntityDao = DAOFactory.getmInstance().getUserUnregisterEntityDao(HibernateUtil.getSession());
        userUnregisterEntityDao.insert(new UserUnregisterEntity("ID1", inner.getSex(), inner.getName(), inner.getNickName(), inner.getPassword(), inner.getPhone(), inner.getIdCard(),  inner.getBankCard(), inner.getVerifyId()));

        httpOutput(response, (new Gson()).toJson(new BaseResponseInner(0, "success")));

    }


}
