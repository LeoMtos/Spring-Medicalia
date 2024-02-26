package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteDto;

public interface IPacienteRepository {

     List<PacienteDto> getAll();
    Optional<PacienteDto> findById(Long id);
    PacienteDto save(PacienteDto pacienteDto);
    void delete(Long id);

}
