package com.medicalia.spring.medicalia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    private final IPacienteService iPacienteService;

    @GetMapping("/")
    public ResponseEntity<List<PacienteRequest>> getAll () {
        return new ResponseEntity<>(iPacienteService.getAll(),HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<PacienteRequest> findById(@PathVariable Long id) {
       return ResponseEntity.of(iPacienteService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<PacienteRequest> save(@RequestBody PacienteRequest pacienteDto) {
        try {
            return new ResponseEntity<>(iPacienteService.save(pacienteDto),HttpStatus.OK);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    
    }

    @PutMapping()
    public ResponseEntity<PacienteRequest> update(@RequestBody PacienteRequest pacienteDto){

        return ResponseEntity.of(iPacienteService.update(pacienteDto));
    }

    @PatchMapping()
    public ResponseEntity<PacienteRequest> updatepa(@RequestBody PacienteRequest pacienteDto){

        return ResponseEntity.of(iPacienteService.update(pacienteDto));

}

}