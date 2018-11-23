package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "ibm_icbc", catalog = "")
public class UserEntity {
    private String userId;
    private int userSex;
    private String userRealName;
    private String userNickName;
    private String userPasswordHash;
    private String userPhoneNumber;
    private String userIdCard;
    private String userBankCard;
    private Timestamp userCreateTime;
    private String userPlaceId;


    public UserEntity(String userId, int userSex, String userRealName, String userNickName, String userPasswordHash, String userPhoneNumber, String userIdCard, String userBankCard, Timestamp userCreateTime, String userPlaceId) {
        this.userId = userId;
        this.userSex = userSex;
        this.userRealName = userRealName;
        this.userNickName = userNickName;
        this.userPasswordHash = userPasswordHash;
        this.userPhoneNumber = userPhoneNumber;
        this.userIdCard = userIdCard;
        this.userBankCard = userBankCard;
        this.userCreateTime = userCreateTime;
        this.userPlaceId = userPlaceId;
    }

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_sex")
    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_real_name")
    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Basic
    @Column(name = "user_nick_name")
    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    @Basic
    @Column(name = "user_password_hash")
    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash;
    }

    @Basic
    @Column(name = "user_phone_number")
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Basic
    @Column(name = "user_id_card")
    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    @Basic
    @Column(name = "user_bank_card")
    public String getUserBankCard() {
        return userBankCard;
    }

    public void setUserBankCard(String userBankCard) {
        this.userBankCard = userBankCard;
    }

    @Basic
    @Column(name = "user_create_time")
    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    @Basic
    @Column(name = "user_place_id")
    public String getUserPlaceId() { return userPlaceId; }

    public void setUserPlaceId(String userPlaceId) { this.userPlaceId = userPlaceId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userSex == that.userSex &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userRealName, that.userRealName) &&
                Objects.equals(userNickName, that.userNickName) &&
                Objects.equals(userPasswordHash, that.userPasswordHash) &&
                Objects.equals(userPhoneNumber, that.userPhoneNumber) &&
                Objects.equals(userIdCard, that.userIdCard) &&
                Objects.equals(userBankCard, that.userBankCard) &&
                Objects.equals(userCreateTime, that.userCreateTime) &&
                Objects.equals(userPlaceId, that.userPlaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userSex, userRealName, userNickName, userPasswordHash, userPhoneNumber, userIdCard, userBankCard, userCreateTime, userPlaceId);
    }
}
