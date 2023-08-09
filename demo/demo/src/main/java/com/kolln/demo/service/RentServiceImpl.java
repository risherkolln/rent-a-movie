package com.kolln.demo.service;

import com.kolln.demo.model.RentEntity;
import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.repository.RentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService{
    private final RentRepository repository;

    public RentServiceImpl(RentRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Rent> findAll() {
        return repository.findAll().stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public Rent findByName(String name) {
        return entityToRentDto(repository.findByCustomer_Name(name));
    }

    @Override
    public Rent findByDni(Long dni) {
        return entityToRentDto(repository.findByCustomer_Dni(dni));
    }

    @Override
    public Rent findBySerialNumber(String serialNumber) {
        return entityToRentDto(repository.findByMovieCopy_SerialNumber(serialNumber));
    }

    private Rent entityToRentDto(RentEntity entity) {
        Rent rentDto = new Rent();
        return rentDto;
    }
}
