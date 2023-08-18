package com.kolln.demo.service;

import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.model.helper.RentalJson;

import java.util.List;

public interface RentService {

    List<Rent> findAll();
    List<Rent> findAllRented();
    List<Rent> findByName(String name);
    List<Rent> findByDni(Long dni);
    List<Rent> findBySerialNumber(String serialNumber);
    List<Rent> findRentedCustomerName(String name);
    void createRental(RentalJson json);
}
