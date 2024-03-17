package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;

public interface IMedicoRepository {

    List<MedicoResponse> getAll();
    Optional<MedicoResponse> findById(Long id);
    MedicoRequest save(MedicoRequest medicoDto);
    void delete(Long id);
    Optional<MedicoRequest> findByNombre(String name);

}
