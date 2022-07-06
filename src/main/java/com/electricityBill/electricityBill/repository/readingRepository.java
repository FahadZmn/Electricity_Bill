package com.electricityBill.electricityBill.repository;

import com.electricityBill.electricityBill.Entity.Costumer;
import com.electricityBill.electricityBill.Entity.Reading;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

//import static sun.net.ftp.FtpDirEntry.Permission.GROUP;

public interface readingRepository extends JpaRepository<Reading,Integer> {
        @Query(value = "FROM Reading WHERE consumerId=?1")
        List<Reading> findByCostumerId(String costumerId);
        @Query(value = "SELECT MAX(reading) FROM Reading WHERE consumerId=?1" )
        Double findByMaxReading(String consumerId);


}
