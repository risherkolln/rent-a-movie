package com.kolln.demo.controller;

import com.kolln.demo.model.dto.Customer;
import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.service.RentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rent-a-movie/rentals")
public class RentController {
    private final RentService service;

    public RentController(RentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rent> findAll() {
        return service.findAll();
    }

    @GetMapping("/{name}")
    public Rent findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @GetMapping("/{dni}")
    public Rent findByDni(@PathVariable Long dni) {
        return service.findByDni(dni);
    }

    @GetMapping("/{serialNumber}")
    public Rent findBySerialNumber(@PathVariable String serialNumber) {
        return service.findBySerialNumber(serialNumber);
    }
}
