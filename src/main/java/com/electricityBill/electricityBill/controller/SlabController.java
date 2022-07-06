package com.electricityBill.electricityBill.controller;


import com.electricityBill.electricityBill.Entity.Slab;
import com.electricityBill.electricityBill.service.SlabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class SlabController {
    @Autowired
    private SlabService service;

    @PostMapping("/addslab")
    public Slab addSlab(@RequestBody Slab slab){
        return service.addSlab(slab);
    }

    @PostMapping("/addslabs")
    public List<Slab> addSlabs(@RequestBody List<Slab> slabs){
        return service.addSlabs(slabs);
    }
    @GetMapping("/getslab/{id}")
    public Slab getSlabByid(@PathVariable(value = "id") Integer id){
        return service.getSlabById(id);
    }
    @GetMapping("/getslabs")
    public List<Slab> getSlabs(){
        return service.getslabs();
    }
    @PutMapping("/updateslab")
    public Slab updateSlab(Slab slab){
        return service.updateSlab(slab);
    }
    @DeleteMapping("deleteslab/{id}")
    public String deleteslab(@PathVariable(value = "id") Integer id){
        return service.deleteSlab(id);

    }
    @GetMapping("/getfinalunit")
    public Integer getfinalunit(){
        return service.getfinalunit();
    }

}
