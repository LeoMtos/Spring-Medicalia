package com.medicalia.spring.medicalia.model.service;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;

public interface IMedicoService {

List<MedicoDto> getAll();
Optional<MedicoDto> findById(Long id);
MedicoDto save(MedicoDto medicoDto);
Optional<MedicoDto> update(MedicoDto medicoDto);
boolean delete(Long id);

}
