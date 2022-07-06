package com.electricityBill.electricityBill.Entity;


//import com.electricityBill.electricityBill.Reading.Readings;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="costumerDetail")
public class Costumer {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)

    private String consumerId;
    private String name;
    private Long phone;
    private String address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "consumerId")
    private List<Reading> readingList;





    public Costumer() {
    }

    public List<Reading> getReadingList() {
        return readingList;
    }

    public void setReadingList(List<Reading> readings) {
        this.readingList = readings;
    }

    public Costumer(String consumerId, String name, Long phone, String address,List<Reading> readingList) {
        this.consumerId = consumerId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.readingList=readingList;
    }



    public Costumer(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
