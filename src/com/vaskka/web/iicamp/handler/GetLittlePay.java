package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.icbc.api.IcbcApiException;
import com.vaskka.web.iicamp.request.LoginRequest;
import com.vaskka.web.iicamp.response.LoginResponse;
import com.vaskka.web.iicamp.utils.MD5Utils;
import com.vaskka.web.iicamp.utils.Util;
import dao.DAOFactory;
import dao.SessionEntityDao;
import dao.UserEntityDao;
import entity.SessionEntity;
import entity.UserEntity;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import static com.vaskka.fun.tiff.Main.testMOpen;
import static com.vaskka.web.iicamp.utils.Util.*;
import static com.vaskka.web.iicamp.utils.Util.httpOutput;

/**
 * @program: FT
 * @description: GetLittlePay 返回小额免密
 * @author: Vaskka
 * @create: 2018/11/24 1:36 PM
 **/

@WebServlet(name = "GetLittlePay")
public class GetLittlePay extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PrintWriter w = response.getWriter();

            String result   = testMOpen();
            w.println(testMOpen());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
