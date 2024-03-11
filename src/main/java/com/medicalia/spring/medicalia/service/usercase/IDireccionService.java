package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;

public interface IDireccionService {

List<DireccionDto> getAll();
Optional<DireccionDto> findById(Long id);
Optional<DireccionDto> update(DireccionDto DireccionDto, Long id);
DireccionDto save(DireccionDto direccionDto);
Optional<DireccionDto>findDireccionByUserId(Long id);

}
