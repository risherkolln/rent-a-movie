package com.kolln.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rent-a-movie/customers")
public class CustomerController {

    @GetMapping
    public void findAllCustomers() {

    }

    @GetMapping("/{id}")
    public void findById(@PathVariable Long id) {

    }

    @PutMapping
    public void createCustomer() {

    }

    @PostMapping
    public void updateCustomer() {

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

    }

}
