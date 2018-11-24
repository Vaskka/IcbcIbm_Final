package com.vaskka.web.iicamp.handler;

import com.icbc.api.IcbcApiException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.vaskka.fun.tiff.Main.testCost;
import static com.vaskka.fun.tiff.Main.testMOpen;
import static com.vaskka.web.iicamp.utils.Util.httpOutput;

/**
 * @program: FT
 * @description: DoLittlePay 执行支付
 * @author: Vaskka
 * @create: 2018/11/24 4:14 PM
 **/

public class DoLittlePay extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            testCost();

            httpOutput(response, "{\"code\": 0, \"msg\": \"success\"}");
        } catch (IcbcApiException e) {
            e.printStackTrace();
        }
    }
}