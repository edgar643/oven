// Java
package com.pepetech.oven.services;

import com.pepetech.oven.entities.Parameters;
import com.pepetech.oven.repositories.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParametersService {
    private final ParametersRepository repository;

    @Autowired
    public ParametersService(ParametersRepository repository) {
        this.repository = repository;
    }

    public Parameters createParameters(Parameters parameters) {
        return repository.save(parameters);
    }

    public List<Parameters> getAllParameters() {
        return repository.findAll();
    }

    public Optional<Parameters> getParametersById(Long id) {
        return repository.findById(id);
    }

    public Parameters updateParameters(Parameters parameters) {
        return repository.save(parameters);
    }

    public void deleteParameters(Long id) {
        repository.deleteById(id);
    }
}