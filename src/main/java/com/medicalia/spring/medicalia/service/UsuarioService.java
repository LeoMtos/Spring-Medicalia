package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.exception.RoleNotFoundException;
import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.model.dto.ERole;
import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    
    private final IUsuarioRepository iUsuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final IDireccionRepository iDireccionRepository;
    private final IMedicoService iMedicoService;
    private final IPacienteService iPacienteService;

    @Override
    public List<UsuarioRequest> getAll() {
           
       return iUsuarioRepository.getAll();
    }

    @Override
    public Optional<UsuarioRequest> findById(Long id) {
        return iUsuarioRepository.findById(id);
    }

    @Override
    public Optional<UsuarioRequest> findByEmail(String email) {
        return iUsuarioRepository.findByEmail(email);
    }


    @Override
    public UsuarioRequest save(UsuarioRequest usuarioDto, ERole role) {
        usuarioDto.setContrasenia(passwordEncoder.encode(usuarioDto.getContrasenia()));
        usuarioDto.setRole(role);

        UsuarioRequest usuarioDto2 = iUsuarioRepository.save(usuarioDto);
        DireccionRequest direccionDto = new DireccionRequest();
        direccionDto.setUsuario(usuarioDto2);
        iDireccionRepository.save(direccionDto);

        if(role.equals(ERole.MEDICO)){
            MedicoRequest medicoDto = new MedicoRequest();
            medicoDto.setUsuario(usuarioDto2);
            iMedicoService.save(medicoDto);
        }
        else if(role.equals(ERole.PACIENTE)){
            PacienteRequest pacienteDto = new PacienteRequest();
            pacienteDto.setUsuario(usuarioDto2);
            iPacienteService.save(pacienteDto);
        }
        else{
            throw new RoleNotFoundException();
        }

    return usuarioDto2;
    }

    @Override
    public Optional<UsuarioRequest> update(UsuarioRequest usuarioDto, Long id) {

        if (iUsuarioRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        usuarioDto.setId(id);
        return Optional.of(iUsuarioRepository.save(usuarioDto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<UsuarioRequest> usuOptional= iUsuarioRepository.findById(id);

        if( usuOptional.isPresent()){
            iUsuarioRepository.delete(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<UsuarioRequest> findByName(String name) {
       return iUsuarioRepository.findByNombreUsuario(name);
    }

    

}
