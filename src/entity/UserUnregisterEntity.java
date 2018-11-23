package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_unregister", schema = "ibm_icbc", catalog = "")
public class UserUnregisterEntity {
    private String userUnregisterId;
    private int userUnregisterSex;
    private String userUnregisterRealName;
    private String userUnregisterNickName;
    private String userUnregisterPasswordHash;
    private String userUnregisterPhoneNumber;
    private String userUnregisterIdCard;
    private String userUnregisterBankCard;
    private String userUnregisterVerifyId;

    public UserUnregisterEntity(String userUnregisterId, int userUnregisterSex, String userUnregisterRealName, String userUnregisterNickName, String userUnregisterPasswordHash, String userUnregisterPhoneNumber, String userUnregisterIdCard, String userUnregisterBankCard, String userUnregisterVerifyId) {
        this.userUnregisterId = userUnregisterId;
        this.userUnregisterSex = userUnregisterSex;
        this.userUnregisterRealName = userUnregisterRealName;
        this.userUnregisterNickName = userUnregisterNickName;
        this.userUnregisterPasswordHash = userUnregisterPasswordHash;
        this.userUnregisterPhoneNumber = userUnregisterPhoneNumber;
        this.userUnregisterIdCard = userUnregisterIdCard;
        this.userUnregisterBankCard = userUnregisterBankCard;
        this.userUnregisterVerifyId = userUnregisterVerifyId;
    }

    @Id
    @Column(name = "user_unregister_id")
    public String getUserUnregisterId() {
        return userUnregisterId;
    }

    public void setUserUnregisterId(String userUnregisterId) {
        this.userUnregisterId = userUnregisterId;
    }

    @Basic
    @Column(name = "user_unregister_sex")
    public int getUserUnregisterSex() {
        return userUnregisterSex;
    }

    public void setUserUnregisterSex(int userUnregisterSex) {
        this.userUnregisterSex = userUnregisterSex;
    }

    @Basic
    @Column(name = "user_unregister_real_name")
    public String getUserUnregisterRealName() {
        return userUnregisterRealName;
    }

    public void setUserUnregisterRealName(String userUnregisterRealName) {
        this.userUnregisterRealName = userUnregisterRealName;
    }

    @Basic
    @Column(name = "user_unregister_nick_name")
    public String getUserUnregisterNickName() {
        return userUnregisterNickName;
    }

    public void setUserUnregisterNickName(String userUnregisterNickName) {
        this.userUnregisterNickName = userUnregisterNickName;
    }

    @Basic
    @Column(name = "user_unregister_password_hash")
    public String getUserUnregisterPasswordHash() {
        return userUnregisterPasswordHash;
    }

    public void setUserUnregisterPasswordHash(String userUnregisterPasswordHash) {
        this.userUnregisterPasswordHash = userUnregisterPasswordHash;
    }

    @Basic
    @Column(name = "user_unregister_phone_number")
    public String getUserUnregisterPhoneNumber() {
        return userUnregisterPhoneNumber;
    }

    public void setUserUnregisterPhoneNumber(String userUnregisterPhoneNumber) {
        this.userUnregisterPhoneNumber = userUnregisterPhoneNumber;
    }

    @Basic
    @Column(name = "user_unregister_id_card")
    public String getUserUnregisterIdCard() {
        return userUnregisterIdCard;
    }

    public void setUserUnregisterIdCard(String userUnregisterIdCard) {
        this.userUnregisterIdCard = userUnregisterIdCard;
    }

    @Basic
    @Column(name = "user_unregister_bank_card")
    public String getUserUnregisterBankCard() {
        return userUnregisterBankCard;
    }

    public void setUserUnregisterBankCard(String userUnregisterBankCard) {
        this.userUnregisterBankCard = userUnregisterBankCard;
    }

    @Basic
    @Column(name = "user_unregister_verify_id")
    public String getUserUnregisterVerifyId() {
        return userUnregisterVerifyId;
    }

    public void setUserUnregisterVerifyId(String userUnregisterVerifyId) {
        this.userUnregisterVerifyId = userUnregisterVerifyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUnregisterEntity that = (UserUnregisterEntity) o;
        return userUnregisterSex == that.userUnregisterSex &&
                Objects.equals(userUnregisterId, that.userUnregisterId) &&
                Objects.equals(userUnregisterRealName, that.userUnregisterRealName) &&
                Objects.equals(userUnregisterNickName, that.userUnregisterNickName) &&
                Objects.equals(userUnregisterPasswordHash, that.userUnregisterPasswordHash) &&
                Objects.equals(userUnregisterPhoneNumber, that.userUnregisterPhoneNumber) &&
                Objects.equals(userUnregisterIdCard, that.userUnregisterIdCard) &&
                Objects.equals(userUnregisterBankCard, that.userUnregisterBankCard) &&
                Objects.equals(userUnregisterVerifyId, that.userUnregisterVerifyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userUnregisterId, userUnregisterSex, userUnregisterRealName, userUnregisterNickName, userUnregisterPasswordHash, userUnregisterPhoneNumber, userUnregisterIdCard, userUnregisterBankCard, userUnregisterVerifyId);
    }

    @Override
    public String toString() {
        return "UserUnregisterEntity{" +
                "userUnregisterId='" + userUnregisterId + '\'' +
                ", userUnregisterSex=" + userUnregisterSex +
                ", userUnregisterRealName='" + userUnregisterRealName + '\'' +
                ", userUnregisterNickName='" + userUnregisterNickName + '\'' +
                ", userUnregisterPasswordHash='" + userUnregisterPasswordHash + '\'' +
                ", userUnregisterPhoneNumber='" + userUnregisterPhoneNumber + '\'' +
                ", userUnregisterIdCard='" + userUnregisterIdCard + '\'' +
                ", userUnregisterBankCard='" + userUnregisterBankCard + '\'' +
                ", userUnregisterVerifyId='" + userUnregisterVerifyId + '\'' +
                '}';
    }
}
