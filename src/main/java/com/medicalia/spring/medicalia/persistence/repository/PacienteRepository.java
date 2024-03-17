package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.repository.IPacienteRepository;
import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;
import com.medicalia.spring.medicalia.persistence.mapper.IPacienteRequestMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IPacienteCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PacienteRepository implements IPacienteRepository{

    private final IPacienteCrudRepository iPacienteCrudRepository;

    private final IPacienteRequestMapper iPacienteMapper;


    @Override
    public List<PacienteRequest> getAll() {
        List<PacienteRequest> pacienteDtos =iPacienteMapper.toPacientesDto(iPacienteCrudRepository.findAll());
        return pacienteDtos;
    }

    @Override
    public Optional<PacienteRequest> findById(Long id) {
        return iPacienteCrudRepository.findById(id).map(iPacienteMapper::toPacienteDto);
    }

    @Override
    public PacienteRequest save(PacienteRequest pacienteDto) {
        PacienteEntity pacienteEntity = iPacienteMapper.toPacienteEntity(pacienteDto);
        return iPacienteMapper.toPacienteDto(iPacienteCrudRepository.save(pacienteEntity));
    }

    @Override
    public void delete(Long id) {
        iPacienteCrudRepository.deleteById(id);
    }

}
