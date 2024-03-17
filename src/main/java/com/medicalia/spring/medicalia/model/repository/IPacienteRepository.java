package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;

public interface IPacienteRepository {

     List<PacienteRequest> getAll();
    Optional<PacienteRequest> findById(Long id);
    PacienteRequest save(PacienteRequest pacienteDto);
    void delete(Long id);

}
