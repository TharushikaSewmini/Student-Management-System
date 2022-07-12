package model;

import java.time.LocalDate;

public class Registration {
    private String regId;
    private LocalDate regDate;
    private String sId;
    private String intakeId;

    public Registration() {
    }

    public Registration(String regId, LocalDate regDate, String sId, String intakeId) {
        this.regId = regId;
        this.regDate = regDate;
        this.sId = sId;
        this.intakeId = intakeId;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(String intakeId) {
        this.intakeId = intakeId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regId='" + regId + '\'' +
                ", regDate=" + regDate +
                ", sId='" + sId + '\'' +
                ", intakeId='" + intakeId + '\'' +
                '}';
    }
}
