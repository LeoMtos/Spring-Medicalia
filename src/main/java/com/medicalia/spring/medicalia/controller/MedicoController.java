package com.medicalia.spring.medicalia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.MedicoDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/medicos")

public class MedicoController {

    private final IMedicoService iMedicoService;

    
    @GetMapping("/")
    public ResponseEntity<List<MedicoResponse>> getAll () {
        return new ResponseEntity<>(iMedicoService.getAll(),HttpStatus.OK);
    }

    // @GetMapping(path="/{id}")
    // public ResponseEntity<MedicoResponse> findById(@PathVariable Long id) {
    //    return ResponseEntity.of(iMedicoService.findById(id));
    // }

    @GetMapping("/{id}")
    public ResponseEntity <MedicoDireccionProjection> findMedicoDireccById(@PathVariable Long id  ) {
        return ResponseEntity.of(iMedicoService.findMedicoDireccionById(id));
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
        //Enviando el usuario autenticado al service para obtener la direccion a editar.

        return ResponseEntity.ok(iMedicoService.update(medicoRequest,authentication.getName()).get());
    }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    
    


}
