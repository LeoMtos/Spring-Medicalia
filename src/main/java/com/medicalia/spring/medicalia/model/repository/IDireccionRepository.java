package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.model.dto.DireccionResponse;

public interface IDireccionRepository {

    List<DireccionResponse> getAll();
    Optional<DireccionResponse> findById(Long id);
    DireccionRequest save(DireccionRequest medicoDto);
    Optional<DireccionRequest>findDireccionByUserId(Long id);

}
