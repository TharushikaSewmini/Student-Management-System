package model;

import java.time.LocalDate;

public class Payment {
    private String paymentId;
    private LocalDate date;
    private Double cost;
    private String regId;

    public Payment() {
    }

    public Payment(String paymentId, LocalDate date, Double cost, String regId) {
        this.paymentId = paymentId;
        this.date = date;
        this.cost = cost;
        this.regId = regId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", date=" + date +
                ", cost=" + cost +
                ", regId='" + regId + '\'' +
                '}';
    }
}
