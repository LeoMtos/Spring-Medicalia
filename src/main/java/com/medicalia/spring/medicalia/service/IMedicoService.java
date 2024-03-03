package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;

public interface IMedicoService {

List<MedicoDto> getAll();
Optional<MedicoDto> findById(Long id);
MedicoDto save(MedicoDto medicoDto, Long id);
Optional<MedicoDto> update(MedicoDto medicoDto);
boolean delete(Long id);

}
