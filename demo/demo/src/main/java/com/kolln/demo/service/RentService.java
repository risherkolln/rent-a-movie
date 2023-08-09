package com.kolln.demo.service;

import com.kolln.demo.model.dto.Rent;

import java.util.List;

public interface RentService {

    List<Rent> findAll();
    Rent findByName(String name);
    Rent findByDni(Long dni);
    Rent findBySerialNumber(String serialNumber);
}
