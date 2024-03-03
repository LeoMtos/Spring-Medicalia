package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.PacienteDto;

public interface IPacienteService {
List<PacienteDto> getAll();
Optional<PacienteDto> findById(Long id);
PacienteDto save(PacienteDto pacienteDto, Long id);
Optional<PacienteDto> update(PacienteDto pacienteDto);
boolean delete(Long id);

}
