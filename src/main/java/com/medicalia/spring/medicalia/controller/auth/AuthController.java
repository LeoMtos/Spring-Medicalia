package com.medicalia.spring.medicalia.controller.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.dto.ERole;
import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.model.dto.PacienteDto;
import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor

@RestController
@RequestMapping("/register")
public class AuthController {
    private final PasswordEncoder passwordEncoder;
    private final IUsuarioService iUsuarioService;
    private final IMedicoService iMedicoService;
    private final IPacienteService iPacienteService;
    private final IDireccionService iDireccionService;

    @PostMapping("/medico")
    public ResponseEntity<UsuarioDto> registerMedico(@RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setRole(ERole.MEDICO); 
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));
        UsuarioDto usuarioDto2 = iUsuarioService.save(usuarioDto);

        //DireccionDto direccionDto = new DireccionDto();

        MedicoDto medicoDto = new MedicoDto();
        medicoDto.setUsuario(usuarioDto2);
        
        DireccionDto direccionDto = new DireccionDto();
        direccionDto.setUsuario(usuarioDto2);

        //medicoDto.setDireccion(iDireccionService.save(new DireccionDto()));
        
        iDireccionService.save(direccionDto);
        iMedicoService.save(medicoDto);
        return ResponseEntity.ok(usuarioDto2);
    }

    @PostMapping("/paciente")
    public ResponseEntity<UsuarioDto> registerPaciente(@RequestBody UsuarioDto usuarioDto) {
        usuarioDto.setRole(ERole.PACIENTE); 
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));
        UsuarioDto usuarioDto2 = iUsuarioService.save(usuarioDto);

        //DireccionDto direccionDto = new DireccionDto();
        

        PacienteDto pacienteDto = new PacienteDto();
        pacienteDto.setUsuario(usuarioDto2);
        //pacienteDto.setDireccion(iDireccionService.save(new DireccionDto()));

        DireccionDto direccionDto = new DireccionDto();
        direccionDto.setUsuario(usuarioDto2);

        iDireccionService.save(direccionDto);
        iPacienteService.save(pacienteDto);

        return ResponseEntity.ok(usuarioDto2);
    }
    
}
