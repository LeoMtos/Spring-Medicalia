package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.persistence.mapper.IUsuarioMapper;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@RestController
@RequestMapping("/direcciones")
public class DireccionController {
    private final IDireccionService iDireccionService;

@GetMapping("/")
public ResponseEntity<List<DireccionDto>> getAll(){
 return ResponseEntity.ok(iDireccionService.getAll());
}

@GetMapping("/{id}")
public ResponseEntity<DireccionDto> findById(@PathVariable Long id) {
    return ResponseEntity.of(iDireccionService.findById(id));
}

@PostMapping("/")
public ResponseEntity<DireccionDto> save(@RequestBody DireccionDto direccionDto ){
    return ResponseEntity.ok(iDireccionService.save(direccionDto));
}

@PutMapping("/")
public ResponseEntity<DireccionDto> update(@RequestBody DireccionDto direccionDto) {
    
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
        return ResponseEntity.ok(iDireccionService.update(direccionDto,authentication.getName()).get());
    }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
}

}
