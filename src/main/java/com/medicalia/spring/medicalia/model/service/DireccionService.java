package com.medicalia.spring.medicalia.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DireccionService implements IDireccionService {

    private final IDireccionRepository iDireccionRepository;

    @Override
    public List<DireccionDto> getAll() {
        return iDireccionRepository.getAll();
    }

    @Override
    public Optional<DireccionDto> findById(Long id) {
        return iDireccionRepository.findById(id);
    }

    @Override
    public Optional<DireccionDto> update(DireccionDto direccionDto, Long id) {
        if (iDireccionRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        direccionDto.setId(id);
        return Optional.of(iDireccionRepository.save(direccionDto));
    }


}
