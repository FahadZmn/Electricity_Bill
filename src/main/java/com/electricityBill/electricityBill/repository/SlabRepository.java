package com.electricityBill.electricityBill.repository;

import com.electricityBill.electricityBill.Entity.Slab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SlabRepository extends JpaRepository<Slab,Integer> {

    @Query("select s.finalUnit from Slab s")
    List<Integer> getfinalunit();

    @Query("select s.slabRate from Slab s where finalUnit=?1")
    Double getslabrate(Integer slabi);

    @Query("select s.slabRate from Slab s where initialUnit=?1")
    Double getslabmaxrate(Integer slabx);

    @Query(value = "SELECT MAX(initialUnit) FROM Slab" )
    Integer findByMaxfinalUnit();
}
