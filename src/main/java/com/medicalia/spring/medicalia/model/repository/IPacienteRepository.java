package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.PacienteResponse;

public interface IPacienteRepository {

     List<PacienteResponse> getAll();

    Optional<PacienteResponse> findById(Long id);
    PacienteRequest save(PacienteRequest pacienteDto);
    void delete(Long id);

    Optional<PacienteRequest> findPacienteByUserId(Long id);

    Optional<PacienteDireccionProjection> findPacienteDireccionByUserId(Long id);
}
