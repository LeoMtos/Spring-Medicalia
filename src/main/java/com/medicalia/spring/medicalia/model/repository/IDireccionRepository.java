package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;

public interface IDireccionRepository {

    List<DireccionDto> getAll();
    Optional<DireccionDto> findById(Long id);
    DireccionDto save(DireccionDto medicoDto);
    Optional<DireccionDto>findDireccionByUserId(Long id);

}
