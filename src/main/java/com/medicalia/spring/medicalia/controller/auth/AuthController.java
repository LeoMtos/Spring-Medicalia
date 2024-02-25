package com.medicalia.spring.medicalia.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.ERole;
import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@RestController
@RequestMapping("/register")
public class AuthController {

    private final IUsuarioService iUsuarioService;

    @PostMapping("/medico")
    public ResponseEntity<UsuarioDto> registerMedico(@RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setRole(ERole.MEDICO); 
        return ResponseEntity.ok(iUsuarioService.save(usuarioDto));
    }

    @PostMapping("/paciente")
    public ResponseEntity<UsuarioDto> registerPaciente(@RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setRole(ERole.PACIENTE); 
        return ResponseEntity.ok(iUsuarioService.save(usuarioDto));
    }
    
}
