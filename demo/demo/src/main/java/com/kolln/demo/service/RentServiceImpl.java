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
    public List<Rent> findByName(String name) {
        return repository.findByCustomer_NameContainingIgnoreCase(name).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findByDni(Long dni) {
        return repository.findByCustomer_DniContaining(dni).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findBySerialNumber(String serialNumber) {
        return repository.findByMovieCopy_SerialNumberContaining(serialNumber).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    private Rent entityToRentDto(RentEntity entity) {
        Rent rentDto = new Rent();

        rentDto.setId(entity.getId());
        rentDto.setRentDate(entity.getRentDate());
        rentDto.setReturnDate(entity.getReturnDate());
        rentDto.setReturned(entity.getReturned());
        return rentDto;
    }
}
