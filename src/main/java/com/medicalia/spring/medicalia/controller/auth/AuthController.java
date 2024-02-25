package com.medicalia.spring.medicalia.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@RestController
@RequestMapping("")
public class AuthController {

    private final IUsuarioService iUsuarioService;

    @PostMapping("/register/medico")
    public ResponseEntity<UsuarioDto> register(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(iUsuarioService.save(usuarioDto));
    }
    
}
