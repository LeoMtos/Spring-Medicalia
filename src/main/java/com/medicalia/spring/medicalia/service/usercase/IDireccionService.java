package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.model.dto.DireccionResponse;

public interface IDireccionService {

List<DireccionResponse> getAll();

Optional<DireccionResponse> findById(Long id);
Optional<DireccionRequest> update(DireccionRequest DireccionDto, String usuarioDto);
DireccionRequest save(DireccionRequest direccionDto);
Optional<DireccionRequest>findDireccionByUserId(Long id);


}
