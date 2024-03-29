package com.medicalia.spring.medicalia.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.ERole;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@RestController
@RequestMapping("api/v1/register")
public class AuthController {
    private final IUsuarioService iUsuarioService;

    @PostMapping("/{role}")
    public ResponseEntity<UsuarioRequest> registerMedico(@RequestBody UsuarioRequest usuarioDto, @PathVariable ERole role) {
        return ResponseEntity.ok( iUsuarioService.save(usuarioDto, role));
    }

}
