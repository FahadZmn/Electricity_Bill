package com.electricityBill.electricityBill.repository;

import com.electricityBill.electricityBill.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer,String> {
        @Query(value = "FROM Costumer where consumer_id=?1")
    Costumer findAllByCostumerId(String consumerId);


        @Query(value = "select c.consumerId,c.name,c.phone,c.address from Costumer c where consumer_id=?1")
        Costumer findCostumer(String consumerId);

        @Query(value = "select c.consumerId,c.name,c.phone,c.address from Costumer c")
        List<Costumer> getCostumers();


}
