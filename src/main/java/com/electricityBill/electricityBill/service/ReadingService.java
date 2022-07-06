package com.electricityBill.electricityBill.service;


import com.electricityBill.electricityBill.Entity.Costumer;
import com.electricityBill.electricityBill.Entity.Reading;
import com.electricityBill.electricityBill.repository.CostumerRepository;
import com.electricityBill.electricityBill.repository.SlabRepository;
import com.electricityBill.electricityBill.repository.readingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.nio.channels.CancelledKeyException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReadingService {
    @Autowired
    private readingRepository readrepository;
    @Autowired
    private CostumerRepository custrepository;
    @Autowired
    private SlabRepository slabRepository;


    public Reading addReading(Reading reading) {


        Reading reading1 = new Reading();
        reading1.setReading(reading.getReading());


        Double lastReading = readrepository.findByMaxReading(reading.getConsumerId());
        reading1.setMonthofreading(LocalDateTime.now());


        if (lastReading == null) {
            reading.setLastReading(0.0);
            lastReading = 0.0;

        } else {
            reading1.setLastReading(lastReading);
        }
        Double unitofconsumption = reading.getReading() - lastReading;
        List<Integer> finalunit = slabRepository.getfinalunit();
        Integer maxfinalunit = slabRepository.findByMaxfinalUnit();
        Double finalunitrate = slabRepository.getslabmaxrate(maxfinalunit);

        Double slabrate = null;
        for (Integer i : finalunit
        ) {
            if (unitofconsumption > maxfinalunit) {
                slabrate = finalunitrate;
                break;
            } else if (unitofconsumption <= i) {
                Integer slabi = i;
                slabrate = slabRepository.getslabrate(slabi);
                break;

            }

        }

        reading1.setBillAmount(unitofconsumption * slabrate);


        Costumer costumer = new Costumer();
        String cr = reading.getConsumerId();
        Costumer cid = custrepository.findById(reading.getConsumerId()).orElse(null);

        reading1.setConsumerId(cr);

        cid.setReadingList(List.of(reading1));
        readrepository.save(reading1);
        return reading1;


    }

    public List<Reading> readings() {
        return readrepository.findAll();
    }

    public String deleteReading(Integer billId) {
        readrepository.deleteById(billId);
        return "Deleted";
    }

    public List<Reading> getReadingById(String costumerId) {
        return readrepository.findByCostumerId(costumerId);
    }

}