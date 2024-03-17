package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

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
public ResponseEntity<List<DireccionRequest>> getAll(){
 return ResponseEntity.ok(iDireccionService.getAll());
}

@GetMapping("/{id}")
public ResponseEntity<DireccionRequest> findById(@PathVariable Long id) {
    return ResponseEntity.of(iDireccionService.findById(id));
}

@PostMapping("/")
public ResponseEntity<DireccionRequest> save(@RequestBody DireccionRequest direccionDto ){
    return ResponseEntity.ok(iDireccionService.save(direccionDto));
}

@PutMapping("/")
public ResponseEntity<DireccionRequest> update(@RequestBody DireccionRequest direccionRequest) {
    
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
        //Enviando el usuario autenticado al service para obtener la direccion a editar.
        return ResponseEntity.ok(iDireccionService.update(direccionRequest,authentication.getName()).get());
    }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
}

}
