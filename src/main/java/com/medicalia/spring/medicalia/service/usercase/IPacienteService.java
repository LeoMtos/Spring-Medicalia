package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;

public interface IPacienteService {
List<PacienteRequest> getAll();
Optional<PacienteRequest> findById(Long id);
PacienteRequest save(PacienteRequest pacienteDto);
Optional<PacienteRequest> update(PacienteRequest pacienteDto);
boolean delete(Long id);

}
