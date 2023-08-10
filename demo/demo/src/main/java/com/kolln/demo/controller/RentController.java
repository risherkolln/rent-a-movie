package com.kolln.demo.controller;

import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.service.RentService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/customers", params = "name")
    public List<Rent> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "/customers", params = "dni")
    public List<Rent> findByDni(@RequestParam Long dni) {
        return service.findByDni(dni);
    }

    @GetMapping(value = "/customers", params = "serialNumber")
    public List<Rent> findBySerialNumber(@RequestParam String serialNumber) {
        return service.findBySerialNumber(serialNumber);
    }
}
