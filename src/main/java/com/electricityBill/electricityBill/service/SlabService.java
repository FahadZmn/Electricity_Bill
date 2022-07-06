package com.electricityBill.electricityBill.service;

import com.electricityBill.electricityBill.Entity.Slab;
import com.electricityBill.electricityBill.repository.SlabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlabService {
    @Autowired
    private SlabRepository slabRepository;

    public Slab addSlab(Slab slab){
        return slabRepository.save(slab);
    }

    public List<Slab> addSlabs(List<Slab> slabs){
        return slabRepository.saveAll(slabs);
    }
    public Slab getSlabById(Integer id){
        return slabRepository.findById(id).orElse(null);
    }
    public List<Slab> getslabs(){
        return slabRepository.findAll();
    }
    public Slab updateSlab(Slab slab){
        Slab excistingSlab=slabRepository.findById(slab.getId()).orElse(null);
        excistingSlab.setInitialUnit(slab.getInitialUnit());
        excistingSlab.setFinalUnit(slab.getFinalUnit());
        excistingSlab.setSlabRate(slab.getSlabRate());
        return slabRepository.save(excistingSlab);
    }

    public String deleteSlab(Integer id){
        slabRepository.deleteById(id);
        return "deleted";
    }

    public Integer getfinalunit(){
       return slabRepository.findByMaxfinalUnit();
    }

}
