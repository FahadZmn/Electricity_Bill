package com.electricityBill.electricityBill.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name="ReadingDetail")
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer billId;
    private Double reading;
    private LocalDateTime monthofreading;
    private Double billAmount;
    private Double lastReading;


    private String consumerId;






    public Reading() {
    }



    public Reading(Integer billId, Double reading, LocalDateTime monthofreading, Double billAmount, Double lastReading) {
        this.billId = billId;
        this.reading = reading;
        this.monthofreading = monthofreading;
        this.billAmount = billAmount;
        this.lastReading = lastReading;

    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Double getReading() {
        return reading;
    }

    public void setReading(Double reading) {
        this.reading = reading;
    }

    public LocalDateTime getMonthofreading() {
        return monthofreading;
    }

    public void setMonthofreading(LocalDateTime monthofreading) {
        this.monthofreading = monthofreading;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Double getLastReading() {
        return lastReading;
    }

    public void setLastReading(Double lastReading) {
        this.lastReading = lastReading;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }


}
