package com.pepetech.oven.controllers;

import com.pepetech.oven.entities.DataOven;
import com.pepetech.oven.services.DataOvenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataOven")
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
    public List<DataOven> getAllDataOvens() {
        return service.getAllDataOvens();
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