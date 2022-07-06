package com.electricityBill.electricityBill.service;

import com.electricityBill.electricityBill.Entity.Costumer;
import com.electricityBill.electricityBill.repository.CostumerRepository;
//import com.electricityBill.electricityBill.repository.readingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
        @Autowired

        private CostumerRepository repository;




        public Costumer saveCostumer(Costumer costumer) {


                return repository.save(costumer);
        }

        public List<Costumer> getCostumers(){

                List<Costumer> costumers=repository.findAll();
                return costumers;
        }
        public Costumer getcostumerById(String consumerId){
                Costumer cid = repository.findById(consumerId).orElse(null);
                Costumer costumer=new Costumer();
                costumer.setConsumerId(consumerId);
                costumer.setName(cid.getName());
                costumer.setPhone(cid.getPhone());
                costumer.setAddress(cid.getAddress());
//                costumer.setReadingList(cid.getReadingList());

                return costumer;
        }

        public Optional<Costumer> getCostumer(String consumerId){
                return repository.findById(consumerId);
        }



}
