package com.pepetech.oven.controllers;

import com.pepetech.oven.entities.DataOven;
import com.pepetech.oven.services.DataOvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/oven-data")
public class DataOvenController {
    private final DataOvenService service;

    @Autowired
    public DataOvenController(DataOvenService service) {
        this.service = service;
    }

    @PostMapping
    public DataOven createDataOven(@RequestBody DataOven dataOven) {
        return service.createDataOven(dataOven);
    }

    @GetMapping
    public List<DataOven> getAllDataOvens(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                          @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return service.getAllDataOvensBydDate();
    }
    @GetMapping("/last")
    public Optional<DataOven> getAllLastDataOven(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return service.getAllDataOvenOnePage().stream().findFirst();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataOven> getDataOvenById(@PathVariable Long id) {
        return service.getDataOvenById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public DataOven updateDataOven(@PathVariable Long id, @RequestBody DataOven dataOven) {
        dataOven.setId(id);
        return service.updateDataOven(dataOven);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDataOven(@PathVariable Long id) {
        service.deleteDataOven(id);
        return ResponseEntity.noContent().build();
    }
}