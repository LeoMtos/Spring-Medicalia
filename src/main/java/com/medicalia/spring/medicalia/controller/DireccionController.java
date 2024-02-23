package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.service.IDireccionService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@AllArgsConstructor
@RestController
@RequestMapping("/direcciones")
public class DireccionController {

    private final IDireccionService iDireccionService;

@GetMapping()
public ResponseEntity<List<DireccionDto>> getAll(){

    return new ResponseEntity<>(iDireccionService.getAll(),HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<DireccionDto> findById(@PathVariable Long id) {
    return ResponseEntity.of(iDireccionService.findById(id));
}

@PutMapping("/{id}")
public ResponseEntity<DireccionDto> update(@RequestBody DireccionDto direccionDto, @PathVariable Long id) {
    return ResponseEntity.of(iDireccionService.update(direccionDto,id));
}

}
