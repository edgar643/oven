package com.pepetech.oven.controllers;

import com.pepetech.oven.entities.DataOven;
import com.pepetech.oven.services.DataOvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        if (startDate == null) {
            startDate = LocalDate.now();
        }
        if (endDate == null) {
            endDate = LocalDate.now().plusDays(-1);
        }
        return service.getAllDataOvens(startDate, endDate);
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