package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_requirement", schema = "ibm_icbc", catalog = "")
public class CarRequirementEntity {
    private String carRequirementId;
    private String carRequirementUserId;
    private int carRequirementDriverSex;
    private int carRequirementPassengerSex;
    private int carRequirementMaxPassenger;

    public CarRequirementEntity() {}

    public CarRequirementEntity(String carRequirementId, String carRequirementUserId, int carRequirementDriverSex, int carRequirementPassengerSex, int carRequirementMaxPassenger) {
        this.carRequirementId = carRequirementId;
        this.carRequirementUserId = carRequirementUserId;
        this.carRequirementDriverSex = carRequirementDriverSex;
        this.carRequirementPassengerSex = carRequirementPassengerSex;
        this.carRequirementMaxPassenger = carRequirementMaxPassenger;
    }

    @Id
    @Column(name = "car_requirement_id")
    public String getCarRequirementId() {
        return carRequirementId;
    }

    public void setCarRequirementId(String carRequirementId) {
        this.carRequirementId = carRequirementId;
    }

    @Basic
    @Column(name = "car_requirement_user_id")
    public String getCarRequirementUserId() {
        return carRequirementUserId;
    }

    public void setCarRequirementUserId(String carRequirementUserId) {
        this.carRequirementUserId = carRequirementUserId;
    }

    @Basic
    @Column(name = "car_requirement_driver_sex")
    public int getCarRequirementDriverSex() {
        return carRequirementDriverSex;
    }

    public void setCarRequirementDriverSex(int carRequirementDriverSex) {
        this.carRequirementDriverSex = carRequirementDriverSex;
    }

    @Basic
    @Column(name = "car_requirement_passenger_sex")
    public int getCarRequirementPassengerSex() {
        return carRequirementPassengerSex;
    }

    public void setCarRequirementPassengerSex(int carRequirementPassengerSex) {
        this.carRequirementPassengerSex = carRequirementPassengerSex;
    }

    @Basic
    @Column(name = "car_requirement_max_passenger")
    public int getCarRequirementMaxPassenger() {
        return carRequirementMaxPassenger;
    }

    public void setCarRequirementMaxPassenger(int carRequirementMaxPassenger) {
        this.carRequirementMaxPassenger = carRequirementMaxPassenger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRequirementEntity that = (CarRequirementEntity) o;
        return carRequirementDriverSex == that.carRequirementDriverSex &&
                carRequirementPassengerSex == that.carRequirementPassengerSex &&
                carRequirementMaxPassenger == that.carRequirementMaxPassenger &&
                Objects.equals(carRequirementId, that.carRequirementId) &&
                Objects.equals(carRequirementUserId, that.carRequirementUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carRequirementId, carRequirementUserId, carRequirementDriverSex, carRequirementPassengerSex, carRequirementMaxPassenger);
    }
}
