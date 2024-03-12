package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DireccionService implements IDireccionService {

    private final IDireccionRepository iDireccionRepository;
    private final IUsuarioService iUsuarioService;

    @Override
    public List<DireccionDto> getAll() {
        return iDireccionRepository.getAll();
    }

    @Override
    public Optional<DireccionDto> findById(Long id) {
        return iDireccionRepository.findById(id);
    }

    @Override
    public Optional<DireccionDto> update(DireccionDto direccionDto, String usuarioDto) {
        Optional<UsuarioDto> usuOptional=iUsuarioService.findByName(usuarioDto);
        if(usuOptional.isPresent()){
            
        }
        return null;
    }

    @Override
    public DireccionDto save(DireccionDto direccionDto) {

        return iDireccionRepository.save(direccionDto);
    }

    @Override
    public Optional<DireccionDto> findDireccionByUserId(Long id) {
       return iDireccionRepository.findDireccionByUserId(id);
    }

    


}
