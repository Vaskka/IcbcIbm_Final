package com.vaskka.web.iicamp.request;

/**
 * @program: FT
 * @description: GetUnregisterUserRequestInner 成为未注册用户
 * @author: Vaskka
 * @create: 2018/11/21 7:03 PM
 **/

public class GetUnregisterUserRequestInner {

    private String name;
    private String idCard;
    private String phone;
    private String nickName;
    private int sex;
    private String bankCard;
    private String password;
    private String verifyId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyId() {
        return verifyId;
    }

    public void setVerifyId(String verifyId) {
        this.verifyId = verifyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }
}
