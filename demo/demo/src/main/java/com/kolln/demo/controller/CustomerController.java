package com.kolln.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rent-a-movie/customers")
public class CustomerController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void findAllCustomers() {

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void findById(@PathVariable Long id) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer() {

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCustomer() {

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {

    }

}
