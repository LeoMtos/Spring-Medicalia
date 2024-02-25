package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.model.service.IMedicoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RequiredArgsConstructor
@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final IMedicoService iMedicoService;
    @GetMapping
    public ResponseEntity<List<MedicoDto>> getAll () {
        return new ResponseEntity<>(iMedicoService.getAll(),HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<MedicoDto> findById(@PathVariable Long id) {
       return ResponseEntity.of(iMedicoService.findById(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<MedicoDto> save(@RequestBody MedicoDto medicoDto, @PathVariable Long id) {
        try {
            return new ResponseEntity<>(iMedicoService.save(medicoDto, id),HttpStatus.OK);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    
    }

    @PutMapping()
    public ResponseEntity<MedicoDto> update(@RequestBody MedicoDto medicoDto){

        return ResponseEntity.of(iMedicoService.update(medicoDto));
    }

    @PatchMapping()
    public ResponseEntity<MedicoDto> updatepa(@RequestBody MedicoDto medicoDto){

        return ResponseEntity.of(iMedicoService.update(medicoDto));
    }

    
    
}
