package com.electricityBill.electricityBill.controller;


import com.electricityBill.electricityBill.Entity.Costumer;
import com.electricityBill.electricityBill.service.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CostumerController {

    @Autowired
    private CostumerService service;
    @PostMapping("/addCostumer")
    public Costumer addCostumer(@RequestBody Costumer costumer){
        return service.saveCostumer(costumer);
    }

//    @PostMapping("/addCostumers")
//    public List<Costumer> addCostumers(@RequestBody List<Costumer> costumers){
//        return service.saveCostumers(costumers);
//    }
    @GetMapping("/getCostumer/{costumerId}")
    public Costumer getCostumerById(@PathVariable(value = "costumerId") String costumerId){
        return service.getcostumerById(costumerId);
    }
    @GetMapping("/getCostumers")
    public List<Costumer> getCostumers(){
        return service.getCostumers();
    }
//    @PutMapping("/updateCostumer/{costumer}")
//    public Costumer updateCostumer(@PathVariable Costumer costumer){
//        return service.updateCostumerById(costumer);
//    }
//    @DeleteMapping("/deleteCostumer/{costumerid}")
//    public String deleteCostumer(@PathVariable String costumerid){
//        return service.deleteCostumer(costumerid);
//    }
    @GetMapping("/Costumer/{consumerId}")
    public Optional<Costumer> getCostumer(@PathVariable(value = "consumerId") String consumerId) {
        return service.getCostumer(consumerId);
    }
}
