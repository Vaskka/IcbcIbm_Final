package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reward_activity", schema = "ibm_icbc", catalog = "")
public class RewardActivityEntity {
    private String rewardActivityId;
    private String rewardActivityName;
    private int rewardActivityCostValue;
    private int rewardActivityGetValue;
    private Timestamp rewardActivityCreateTime;
    private int rewardActivityIsValid;

    @Id
    @Column(name = "reward_activity_id")
    public String getRewardActivityId() {
        return rewardActivityId;
    }

    public void setRewardActivityId(String rewardActivityId) {
        this.rewardActivityId = rewardActivityId;
    }

    @Basic
    @Column(name = "reward_activity_name")
    public String getRewardActivityName() {
        return rewardActivityName;
    }

    public void setRewardActivityName(String rewardActivityName) {
        this.rewardActivityName = rewardActivityName;
    }

    @Basic
    @Column(name = "reward_activity_cost_value")
    public int getRewardActivityCostValue() {
        return rewardActivityCostValue;
    }

    public void setRewardActivityCostValue(int rewardActivityCostValue) {
        this.rewardActivityCostValue = rewardActivityCostValue;
    }

    @Basic
    @Column(name = "reward_activity_get_value")
    public int getRewardActivityGetValue() {
        return rewardActivityGetValue;
    }

    public void setRewardActivityGetValue(int rewardActivityGetValue) {
        this.rewardActivityGetValue = rewardActivityGetValue;
    }

    @Basic
    @Column(name = "reward_activity_create_time")
    public Timestamp getRewardActivityCreateTime() {
        return rewardActivityCreateTime;
    }

    public void setRewardActivityCreateTime(Timestamp rewardActivityCreateTime) {
        this.rewardActivityCreateTime = rewardActivityCreateTime;
    }

    @Basic
    @Column(name = "reward_activity_is_valid")
    public int getRewardActivityIsValid() {
        return rewardActivityIsValid;
    }

    public void setRewardActivityIsValid(int rewardActivityIsValid) {
        this.rewardActivityIsValid = rewardActivityIsValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RewardActivityEntity that = (RewardActivityEntity) o;
        return rewardActivityCostValue == that.rewardActivityCostValue &&
                rewardActivityGetValue == that.rewardActivityGetValue &&
                rewardActivityIsValid == that.rewardActivityIsValid &&
                Objects.equals(rewardActivityId, that.rewardActivityId) &&
                Objects.equals(rewardActivityName, that.rewardActivityName) &&
                Objects.equals(rewardActivityCreateTime, that.rewardActivityCreateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewardActivityId, rewardActivityName, rewardActivityCostValue, rewardActivityGetValue, rewardActivityCreateTime, rewardActivityIsValid);
    }
}
