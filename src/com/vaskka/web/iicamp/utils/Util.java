package com.vaskka.web.iicamp.utils;

import com.google.gson.Gson;
import com.sun.tools.corba.se.idl.constExpr.Times;
import com.vaskka.web.iicamp.handler.CreatePinCarOrder;
import com.vaskka.web.iicamp.handler.GetUnregisterUser;
import com.vaskka.web.iicamp.handler.VerifyCode;
import com.vaskka.web.iicamp.request.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: FT
 * @description: Util 常用类
 * @author: Vaskka
 * @create: 2018/11/21 6:35 PM
 **/

public class Util {


    /**
     * 读取body
     * @param request HttpServletRequest
     * @return String
     */
    public static String getRequestBody(HttpServletRequest request) {
        try (BufferedReader reader = request.getReader()) {
            StringBuilder stringBuilder = new StringBuilder();

            String s;
            while ((s = reader.readLine()) != null) {
                stringBuilder.append(s);
            }

            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;


    }


    /**
     * 输出网络请求
     * @param response HttpServletResponse
     * @param content String
     * @throws IOException IOException
     */
    public static void httpOutput(HttpServletResponse response, String content) throws IOException {
        response.setContentType("application/json");
        response.getWriter().println(content);
    }


    /**
     * 获得Request GetUnregisterUserRequestInner
     * @param request HttpServletRequest
     * @return GetUnregisterUserRequestInner
     */
    public static GetUnregisterUserRequestInner getUnregisterUserRequestInner(HttpServletRequest request) {
        String body = getRequestBody(request);

        GetUnregisterUserRequestInner u = (new Gson().fromJson(body, GetUnregisterUserRequestInner.class));

        return u;
    }


    /**
     * 用户雁阵验证码
     * @param request HttpServletRequest
     * @return VerifyCodeRequest
     */
    public static VerifyCodeRequest getVerifyCodeRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        VerifyCodeRequest re = (new Gson()).fromJson(body, VerifyCodeRequest.class);

        return re;
    }


    /**
     * 用户登陆请求
     * @param request
     * @return
     */
    public static LoginRequest getLoginRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        LoginRequest re = (new Gson()).fromJson(body, LoginRequest.class);

        return re;
    }


    /**
     * 得到同步位置信息请求
     * @param request HttpServletRequest
     * @return
     */
    public static SyncPositionRequest getSyncPositionRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        SyncPositionRequest spr  = (new Gson()).fromJson(body, SyncPositionRequest.class);

        return  spr;

    }


    /**
     * 得到创建拼车订单的请求
     * @param request HttpServletRequest
     * @return CreatePinCarOrderRequest
     */
    public static CreatePinCarOrderRequest getCreatePinCarOrderRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        CreatePinCarOrderRequest req = (new Gson()).fromJson(body, CreatePinCarOrderRequest.class);

        return req;

    }


    /**
     * 得到合适的拼单请求
     * @param request GetAppropriatePinCarRequest
     * @return
     */
    public static GetAppropriatePinCarRequest getAppropriatePinCarRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        GetAppropriatePinCarRequest req = (new Gson()).fromJson(body, GetAppropriatePinCarRequest.class);

        return req;
    }


    /**
     * 加入拼车订单
     * @param request
     * @return
     */
    public static JoinPinCarRequest getJoinPinCarRequest(HttpServletRequest request) {
        String body = getRequestBody(request);

        JoinPinCarRequest req = (new Gson()).fromJson(body, JoinPinCarRequest.class);

        return req;
    }


    /**
     * 获得某个商家全部拼单请求
     * @param request
     * @return
     */
    public static GetBusinessAllPinGoodOrderRequest getBusinessAllPinGoodOrderRequest(HttpServletRequest request) {
        String body = getRequestBody(request);
        GetBusinessAllPinGoodOrderRequest req = (new Gson()).fromJson(body, GetBusinessAllPinGoodOrderRequest.class);


        return req;

    }


    /**
     * 获得拼单请求
     * @param request 请求
     * @return
     */
    public static CreateGoodOrderRequest getCreateGoodOrderRequest(HttpServletRequest request) {
        String body = getRequestBody(request);
        CreateGoodOrderRequest req = (new Gson()).fromJson(body, CreateGoodOrderRequest.class);

        return req;
    }


    /**
     * 获得全部商品的list
     * @param request
     * @return
     */
    public static GetBusinessAllItemRequest getBusinessAllItemRequest(HttpServletRequest request) {
        String body = getRequestBody(request);
        GetBusinessAllItemRequest req = (new Gson()).fromJson(body, GetBusinessAllItemRequest.class);

        return req;
    }

    /**
     * 随机数
     * @return 当前时间String yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return (df.format(new Date()));// new Date()为获取当前系统时间
    }




    /**
     * 获得随机数
     * @return
     */
    public static String getRandInt() {
        java.util.Random r=new java.util.Random(System.currentTimeMillis());

        return String.valueOf(r.nextInt());
    }


    /**
     * 获得随机id
     * @param name 名字
     * @return String
     */
    public static String getRandomId(String name) {

        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append("-");

        int f = name.length() + 1;

        String s = MD5Utils.MD5Encode("asd", null);

        sb.append(s);

        return sb.toString().substring(0, 32);
    }

    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     * @param strDate
     *            表示日期的字符串
     * @param dateFormat
     *            传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static java.sql.Timestamp strToSqlDate(String strDate, String dateFormat) {

        // 默认格式
        if (dateFormat == null) {
            dateFormat = "yyyy-MM-dd HH:mm:ss";
        }


        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        java.util.Date date = null;

        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
        return dateSQL;
    }


    /**
     * 时间戳转Date
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(Timestamp timestamp) {
        Date date = new Date();
        try {
            date = timestamp;

            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
