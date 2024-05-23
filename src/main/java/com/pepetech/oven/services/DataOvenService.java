package com.pepetech.oven.services;

import com.pepetech.oven.entities.DataOven;
import com.pepetech.oven.repositories.DataOvenRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DataOvenService {
    private final DataOvenRepository repository;

    public DataOven createDataOven(DataOven dataOven) {
        final HashMap<String, Object> weatherDataMap = (HashMap<String, Object>) WeatherService.getCurrentWeatherData();
        final HashMap<String, Object> weatherDataMapMain = (HashMap<String, Object>) weatherDataMap.get("main");
        final var temperature = weatherDataMapMain.get("temp");
        dataOven.setForecastTemperature((Double) temperature);
        return repository.save(dataOven);
    }

    public List<DataOven> getAllDataOvens(LocalDate startDate, LocalDate endDate) {
        return repository.findAll();
    }

    public List<DataOven> getAllDataOvensBydDate() {
        Pageable pageable = PageRequest.of(0, 10000, Sort.by("date").descending());
        return repository.findAll(pageable).getContent();
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