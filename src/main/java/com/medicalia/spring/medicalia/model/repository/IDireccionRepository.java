package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionRequest;

public interface IDireccionRepository {

    List<DireccionRequest> getAll();
    Optional<DireccionRequest> findById(Long id);
    DireccionRequest save(DireccionRequest medicoDto);
    Optional<DireccionRequest>findDireccionByUserId(Long id);

}
