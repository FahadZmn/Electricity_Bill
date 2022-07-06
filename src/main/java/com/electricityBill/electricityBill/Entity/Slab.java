package com.electricityBill.electricityBill.Entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "Slab_Details")
public class Slab {
    @Id

    private Integer id;
    private int initialUnit;
    @Column(name = "finalunit")
    private int finalUnit;
    private Double slabRate;

    public Slab() {
    }

    public Slab(int id, int initialUnit, int finalUnit, Double slabRate) {
        this.id = id;
        this.initialUnit = initialUnit;
        this.finalUnit = finalUnit;
        this.slabRate = slabRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialUnit() {
        return initialUnit;
    }

    public void setInitialUnit(int initialUnit) {
        this.initialUnit = initialUnit;
    }

    public int getFinalUnit() {
        return finalUnit;
    }

    public void setFinalUnit(int finalUnit) {
        this.finalUnit = finalUnit;
    }

    public Double getSlabRate() {
        return slabRate;
    }

    public void setSlabRate(Double slabRate) {
        this.slabRate = slabRate;
    }
}
