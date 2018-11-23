package com.vaskka.web.iicamp.response;

import com.vaskka.web.iicamp.response.BaseResponseInner;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: FT
 * @description: GetAppropriatePinCarResponse 获取可拼车的返回
 * @author: Vaskka
 * @create: 2018/11/23 2:43 AM
 **/

public class GetAppropriatePinCarResponse extends BaseResponseInner {

    public static class AppropriatePinCarInner {
        private String pinCarOrderId;

         public static class UserInner {
            private String userId;

            private String nickName;

            private String destinationName;

            public UserInner(String userId, String nickName, String destinationName) {
                this.userId = userId;
                this.nickName = nickName;
                this.destinationName = destinationName;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getDestinationName() {
                return destinationName;
            }

            public void setDestinationName(String destinationName) {
                this.destinationName = destinationName;
            }
        }

        List<UserInner> userInners;

        public AppropriatePinCarInner(String pinCarOrderId, List<UserInner> userInners) {
            this.pinCarOrderId = pinCarOrderId;
            this.userInners = userInners;
        }

        public String getPinCarOrderId() {
            return pinCarOrderId;
        }

        public void setPinCarOrderId(String pinCarOrderId) {
            this.pinCarOrderId = pinCarOrderId;
        }

        public List<UserInner> getUserInners() {
            return userInners;
        }

        public void setUserInners(List<UserInner> userInners) {
            this.userInners = userInners;
        }
    }

    private List<AppropriatePinCarInner> appropriatePinCarInners;

    public List<AppropriatePinCarInner> getAppropriatePinCarInners() {
        return appropriatePinCarInners;
    }

    public void setAppropriatePinCarInners(List<AppropriatePinCarInner> appropriatePinCarInners) {
        this.appropriatePinCarInners = appropriatePinCarInners;
    }

    public GetAppropriatePinCarResponse(int code, String msg, List<AppropriatePinCarInner> appropriatePinCarInners) {
        super(code, msg);
        this.appropriatePinCarInners = appropriatePinCarInners;
    }
}
