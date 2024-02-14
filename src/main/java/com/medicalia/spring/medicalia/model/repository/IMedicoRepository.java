package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;

public interface IMedicoRepository {

    List<MedicoDto> getAll();
    Optional<MedicoDto> findById(Long id);
    MedicoDto save(MedicoDto medicoDto);
    void delete(Long id);

}
