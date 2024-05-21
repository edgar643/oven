package com.pepetech.oven.controllers;

import com.pepetech.oven.entities.Parameters;
import com.pepetech.oven.services.ParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oven-data")
public class ParametersController {
    private final ParametersService service;

    @Autowired
    public ParametersController(ParametersService service) {
        this.service = service;
    }

    @PostMapping
    public Parameters createParameters(@RequestBody Parameters parameters) {
        return service.createParameters(parameters);
    }

    @GetMapping
    public List<Parameters> getAllParameters() {
        return service.getAllParameters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parameters> getParametersById(@PathVariable Long id) {
        return service.getParametersById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Parameters updateParameters(@PathVariable Long id, @RequestBody Parameters parameters) {
        parameters.setId(id);
        return service.updateParameters(parameters);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParameters(@PathVariable Long id) {
        service.deleteParameters(id);
        return ResponseEntity.noContent().build();
    }
}