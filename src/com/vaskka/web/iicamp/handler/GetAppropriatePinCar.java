package com.vaskka.web.iicamp.handler;

import com.google.gson.Gson;
import com.vaskka.web.iicamp.request.GetAppropriatePinCarRequest;
import com.vaskka.web.iicamp.response.GetAppropriatePinCarResponse;
import com.vaskka.web.iicamp.utils.DistanceUtil;
import dao.*;
import entity.*;
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
 * @description: GetAppropriatePinCar 获得合适的拼车list
 * @author: Vaskka
 * @create: 2018/11/23 2:15 AM
 **/

@WebServlet(name = "GetAppropriatePinCar")
public class GetAppropriatePinCar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetAppropriatePinCarRequest req = getAppropriatePinCarRequest(request);

        // 拿到全部正在进行的订单
        PinCarOrderEntityDao pinCarOrderEntityDao = DAOFactory.getmInstance().getPinCarOrderEntityDao(HibernateUtil.getSession());
        List<PinCarOrderEntity> list = pinCarOrderEntityDao.query("pinCarOrderStatus", 1);


        // 构造返回对象
        List<GetAppropriatePinCarResponse.AppropriatePinCarInner> respInnerList = new ArrayList<>();


        // 过滤距离
        for (PinCarOrderEntity order : list) {


            // 拿到出发地点经纬度
            String startPlaceId = order.getPinCarOrderStartPlaceId();
            PlaceEntityDao placeEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
            List<PlaceEntity> startPlaceList = placeEntityDao.query("placeId", startPlaceId);

            double startPlaceLongitude = startPlaceList.get(0).getLongitude();
            double startPlaceLatitude  = startPlaceList.get(0).getLatitude();

            // 计算距离
            double distance = DistanceUtil.LantitudeLongitudeDist(req.getStartPlace().getLongitude(), req.getStartPlace().getLatitude(), startPlaceLongitude, startPlaceLatitude);

            if (distance <= 1) {
                // 拿到目的地Name
                PlaceEntityDao destinationPlaceEntityDao = DAOFactory.getmInstance().getPlaceEntityDao(HibernateUtil.getSession());
                List<PlaceEntity> singlePlaceList = destinationPlaceEntityDao.query("placeId", order.getPinCarOrderDestinationId());
                String destinationName = singlePlaceList.get(0).getPlaceName();

                // 构造返回数据
                MappingCarUserEntityDao mappingCarUserEntityDao = DAOFactory.getmInstance().getMappingCarUserEntityDao(HibernateUtil.getSession());
                List<MappingCarUserEntity> li = mappingCarUserEntityDao.query("mappingPinCarOrderId", order.getPinCarOrderId());

                List<GetAppropriatePinCarResponse.AppropriatePinCarInner.UserInner> userInners = new ArrayList<>();
                for (MappingCarUserEntity entity : li) {
                    String uid = entity.getMappingUserId();

                    UserEntityDao userEntityDao = DAOFactory.getmInstance().getUserEntityDao(HibernateUtil.getSession());
                    List<UserEntity> singleUserList = userEntityDao.query("userId", uid);

                    GetAppropriatePinCarResponse.AppropriatePinCarInner.UserInner inner = new GetAppropriatePinCarResponse.AppropriatePinCarInner.UserInner(singleUserList.get(0).getUserId(), singleUserList.get(0).getUserNickName(), destinationName);
                    userInners.add(inner);
                }
                respInnerList.add(new GetAppropriatePinCarResponse.AppropriatePinCarInner(order.getPinCarOrderId(), userInners));

            }
        }



        httpOutput(response, (new Gson()).toJson(new GetAppropriatePinCarResponse(0, "success", respInnerList)));

    }
}
