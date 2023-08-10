package com.kolln.demo.repository;

import com.kolln.demo.model.RentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<RentEntity, Long> {
    List<RentEntity> findByCustomer_NameContainingIgnoreCase(String name);
    List<RentEntity> findByCustomer_DniContaining(Long dni);
    List<RentEntity> findByMovieCopy_SerialNumberContaining(String serialNumber);
}
