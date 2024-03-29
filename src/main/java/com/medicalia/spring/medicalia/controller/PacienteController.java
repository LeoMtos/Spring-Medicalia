package com.medicalia.spring.medicalia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.PacienteDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.PacienteResponse;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/pacientes")

public class PacienteController {

    private final IPacienteService iPacienteService;

    @GetMapping("/")
    public ResponseEntity<List<PacienteResponse>> getAll () {
        return new ResponseEntity<>(iPacienteService.getAll(),HttpStatus.OK);
    }

    // @GetMapping(path="/{id}")
    // public ResponseEntity<PacienteResponse> findById(@PathVariable Long id) {
    //    return ResponseEntity.of(iPacienteService.findById(id));
    // }

    @GetMapping("/{id}")
    public ResponseEntity <PacienteDireccionProjection> findPacienteDireccById(@PathVariable Long id  ) {
        return ResponseEntity.of(iPacienteService.findPacienteDireccionById(id));
    }
    

    @PutMapping("")
    public ResponseEntity<PacienteRequest> update(@RequestBody PacienteRequest pacienteRequest){

         Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

         if (authentication != null && authentication.isAuthenticated()) {
            //Enviando el usuario autenticado al service para obtener la direccion a editar.
    
            return ResponseEntity.ok(iPacienteService.update(pacienteRequest, authentication.getName()).get());
        }
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("")
    public ResponseEntity<PacienteRequest> save(@RequestBody PacienteRequest pacienteDto) {
        try {
            return new ResponseEntity<>(iPacienteService.save(pacienteDto),HttpStatus.OK);    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    
    }

   

    


}