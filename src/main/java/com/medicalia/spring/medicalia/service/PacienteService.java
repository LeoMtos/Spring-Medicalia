package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IPacienteRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository iPacienteRepository;
    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public List<PacienteRequest> getAll() {
        return iPacienteRepository.getAll();
    }

    @Override
    public Optional<PacienteRequest> findById(Long id) {
        return iPacienteRepository.findById(id);
    }

    @Override
    public PacienteRequest save(PacienteRequest pacienteDto) {
      
        // Optional<UsuarioDto> usuarioDto = iUsuarioRepository.findById(id);
        // if(usuarioDto.isPresent()){
        // pacienteDto.setUsuario(usuarioDto.get());
        // }
        // else{
        //     throw new RuntimeException("Usuario no encontrado");
        // }

        return iPacienteRepository.save(pacienteDto);
    }

    @Override
    public Optional<PacienteRequest> update(PacienteRequest pacienteDto) {
        Optional<PacienteRequest> pacienteDto2 = iPacienteRepository.findById(pacienteDto.getId());


        if (pacienteDto2.isEmpty()) {
            return Optional.empty();
        }
        pacienteDto.setNombre(pacienteDto.getNombre()== null ? pacienteDto2.get().getNombre() : pacienteDto.getNombre());
        return Optional.of(iPacienteRepository.save(pacienteDto));
    }
    

    @Override
    public boolean delete(Long id) {
       return false;
    }


}
