package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.PacienteResponse;

public interface IPacienteService {

List<PacienteResponse> getAll();
Optional<PacienteResponse> findById(Long id);
PacienteRequest save(PacienteRequest pacienteDto);
Optional<PacienteRequest> update(PacienteRequest pacienteRequest, String usuarioRequest);
boolean delete(Long id);

Optional<PacienteDireccionProjection> findPacienteDireccionById(Long id);

}
