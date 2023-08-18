package com.kolln.demo.controller;

import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.model.helper.RentalJson;
import com.kolln.demo.service.RentService;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/rented")
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findAllRented() {
        return service.findAllRented();
    }

    @GetMapping(value = "/customers", params = "name")
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findByName(@RequestParam String name) {
        return service.findByName(name);
    }

    @GetMapping(value = "/customers", params = "dni")
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findByDni(@RequestParam Long dni) {
        return service.findByDni(dni);
    }

    @GetMapping(value = "/customers", params = "serialNumber")
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findBySerialNumber(@RequestParam String serialNumber) {
        return service.findBySerialNumber(serialNumber);
    }

    @GetMapping(value = "/rented", params = "name")
    @ResponseStatus(HttpStatus.OK)
    public List<Rent> findRentedCustomerName(@RequestParam String name) {
        return service.findRentedCustomerName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRental(@RequestBody RentalJson json) {
        service.createRental(json);
    }
}
