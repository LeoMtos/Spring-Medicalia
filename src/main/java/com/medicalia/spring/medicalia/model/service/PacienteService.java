package com.medicalia.spring.medicalia.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.model.dto.PacienteDto;
import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;
import com.medicalia.spring.medicalia.model.repository.IPacienteRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository iPacienteRepository;
    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public List<PacienteDto> getAll() {
        return iPacienteRepository.getAll();
    }

    @Override
    public Optional<PacienteDto> findById(Long id) {
        return iPacienteRepository.findById(id);
    }

    @Override
    public PacienteDto save(PacienteDto pacienteDto, Long id) {
      
        Optional<UsuarioDto> usuarioDto = iUsuarioRepository.findById(id);
        if(usuarioDto.isPresent()){
        pacienteDto.setUsuario(usuarioDto.get());
        }
        else{
            throw new RuntimeException("Usuario no encontrado");
        }

        return iPacienteRepository.save(pacienteDto);
    }

    @Override
    public Optional<PacienteDto> update(PacienteDto pacienteDto) {
        Optional<PacienteDto> pacienteDto2 = iPacienteRepository.findById(pacienteDto.getId());


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
