package com.kolln.demo.service;

import com.kolln.demo.model.RentEntity;
import com.kolln.demo.model.dto.Rent;
import com.kolln.demo.model.helper.RentalJson;
import com.kolln.demo.repository.CustomerRepository;
import com.kolln.demo.repository.MovieCopyRepository;
import com.kolln.demo.repository.RentRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentServiceImpl implements RentService{
    private final RentRepository rentRepository;
    private final CustomerRepository customerRepository;
    private final MovieCopyRepository movieCopyRepository;

    public RentServiceImpl(RentRepository repository,
                           CustomerRepository customerRepository,
                           MovieCopyRepository movieCopyRepository) {
        this.rentRepository = repository;
        this.customerRepository = customerRepository;
        this.movieCopyRepository = movieCopyRepository;
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll().stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findAllRented() {
        return rentRepository.findByReturnedFalse().stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findByName(String name) {
        return rentRepository.findByCustomer_NameContainingIgnoreCase(name).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findByDni(Long dni) {
        return rentRepository.findByCustomer_DniContaining(dni).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findBySerialNumber(String serialNumber) {
        return rentRepository.findByMovieCopy_SerialNumberContaining(serialNumber).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rent> findRentedCustomerName(String name) {
        return rentRepository.findByReturnedFalseAndCustomerNameContaining(name).stream()
                .map(this::entityToRentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void createRental(RentalJson json) {
        RentEntity entity = new RentEntity();

        entity.setRentDate(LocalDateTime.now());
        entity.setReturned(false);
        entity.setCustomer(customerRepository.findById(json.getCustomerId())
                .orElseThrow(ResourceNotFoundException::new));
        entity.setMovieCopy(movieCopyRepository.findById(json.getMovieCopyId())
                .orElseThrow(ResourceNotFoundException::new));

        rentRepository.save(entity);
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
