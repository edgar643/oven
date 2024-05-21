package com.pepetech.oven.services;

import com.pepetech.oven.entities.DataOven;
import com.pepetech.oven.repositories.DataOvenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DataOvenService {
    private final DataOvenRepository repository;

    @Autowired
    public DataOvenService(DataOvenRepository repository) {
        this.repository = repository;
    }

    public DataOven createDataOven(DataOven dataOven) {
        return repository.save(dataOven);
    }

    public List<DataOven> getAllDataOvens(LocalDate startDate, LocalDate endDate) {
        return repository.findAllByDateBetween(startDate, endDate);
    }

    public Optional<DataOven> getDataOvenById(Long id) {
        return repository.findById(id);
    }

    public DataOven updateDataOven(DataOven dataOven) {
        return repository.save(dataOven);
    }

    public void deleteDataOven(Long id) {
        repository.deleteById(id);
    }
}