package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.GetUnregisterUserRequestInner;
import com.vaskka.web.iicamp.request.SyncPositionRequest;
import com.vaskka.web.iicamp.response.BaseResponseInner;
import com.vaskka.web.iicamp.utils.Util;
import dao.DAOFactory;
import dao.PlaceEntityDao;
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
import java.util.List;

import static com.vaskka.web.iicamp.utils.Util.*;
import static com.vaskka.web.iicamp.utils.Util.getNowTime;

/**
 * @program: FT
 * @description: SyncPosition 同步用户位置信息
 * @author: Vaskka
 * @create: 2018/11/23 12:41 AM
 **/
@WebServlet(name = "SyncPosition")
public class SyncPosition extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SyncPositionRequest req = getSyncPositionRequest(request);

        UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());

        List<UserEntity>  list = userEntityDao.query("userId", req.getUserId());

        if (list.size() == 0) {
            httpOutput(response, (new Gson()).toJson(new BaseResponseInner(1, "user not exist")));
            return;
        }

        PlaceEntityDao placeEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
        placeEntityDao.update(list.get(0).getUserPlaceId(), req.getLongitude(), req.getLatitude(), req.getPlaceName());

        httpOutput(response, (new Gson()).toJson(new BaseResponseInner(0, "success")));

    }
}
