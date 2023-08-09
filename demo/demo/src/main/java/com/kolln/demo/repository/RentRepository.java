package com.kolln.demo.repository;

import com.kolln.demo.model.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {
    RentEntity findByCustomer_Name(String name);
    RentEntity findByCustomer_Dni(Long dni);
    RentEntity findByMovieCopy_SerialNumber(String serialNumber);
}
