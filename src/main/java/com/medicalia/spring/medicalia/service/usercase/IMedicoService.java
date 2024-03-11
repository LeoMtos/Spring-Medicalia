package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;

public interface IMedicoService {

List<MedicoDto> getAll();
Optional<MedicoDto> findById(Long id);
Optional<MedicoDto> findByNombre(String nombre);
MedicoDto save(MedicoDto medicoDto);
Optional<MedicoDto> update(MedicoDto medicoDto);
boolean delete(Long id);

}
