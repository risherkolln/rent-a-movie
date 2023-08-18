package com.kolln.demo.service;

import com.kolln.demo.model.MovieCopyEntity;
import com.kolln.demo.model.dto.MovieCopy;
import com.kolln.demo.model.dto.Rent;

import java.util.List;

public interface RentService {

    List<Rent> findAll();
    List<Rent> findAllRented();
    List<Rent> findByName(String name);
    List<Rent> findByDni(Long dni);
    List<Rent> findBySerialNumber(String serialNumber);
    List<Rent> findRentedCustomerName(String name);
}
