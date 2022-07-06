package com.electricityBill.electricityBill.controller;

import com.electricityBill.electricityBill.Entity.Costumer;
import com.electricityBill.electricityBill.Entity.Reading;
import com.electricityBill.electricityBill.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
public class ReadingController {

    @Autowired
    private ReadingService readingService;

    @PostMapping("/addreading")
    public Reading addreading(@RequestBody Reading reading){

        return readingService.addReading(reading);
    }


    @GetMapping("/getReadings")
    public List<Reading> readings(){
        return readingService.readings();
    }


    @DeleteMapping("/delete/{billId}")
    public String deleteReading(@PathVariable Integer billId){
        return readingService.deleteReading(billId);
    }


    @GetMapping("/getreading/{costumerId}")
    public List<Reading> getReadingById(@PathVariable(value = "costumerId") String costumerId){
        return readingService.getReadingById(costumerId);
    }


//    @PostMapping("/addnewreading")
//    public Reading addNewReading(@RequestBody Reading reading){
//        return readingService.saveReading(reading);
//    }

//    @GetMapping("/getreadingsorted/{consumerId}")
//    public List<Double> getreadingbysorting(@PathVariable(value = "consumerId")String consumerId){
//        return readingService.getorderbycostumerid(consumerId);
//    }

}