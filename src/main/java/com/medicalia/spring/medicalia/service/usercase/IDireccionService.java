package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionRequest;

public interface IDireccionService {

List<DireccionRequest> getAll();
Optional<DireccionRequest> findById(Long id);
Optional<DireccionRequest> update(DireccionRequest DireccionDto, String usuarioDto);
DireccionRequest save(DireccionRequest direccionDto);
Optional<DireccionRequest>findDireccionByUserId(Long id);


}
