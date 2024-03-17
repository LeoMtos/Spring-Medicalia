package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("/medicos")

public class MedicoController {

    private final IMedicoService iMedicoService;

    
    @GetMapping("/")
    public ResponseEntity<List<MedicoResponse>> getAll () {
        return new ResponseEntity<>(iMedicoService.getAll(),HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable Long id) {
       return ResponseEntity.of(iMedicoService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MedicoRequest> save(@RequestBody MedicoRequest medicoRequest) {
        try {
            
            return new ResponseEntity<>(iMedicoService.save(medicoRequest),HttpStatus.OK);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    
    }

    @PutMapping("/")
    public ResponseEntity<MedicoRequest> update(@RequestBody MedicoRequest medicoRequest){


        return ResponseEntity.of(iMedicoService.update(medicoRequest));
    }


}
