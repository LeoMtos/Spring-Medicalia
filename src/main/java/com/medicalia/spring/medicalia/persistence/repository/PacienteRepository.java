package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.PacienteDto;
import com.medicalia.spring.medicalia.model.repository.IPacienteRepository;
import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;
import com.medicalia.spring.medicalia.persistence.mapper.IPacienteMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IPacienteCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class PacienteRepository implements IPacienteRepository{

    private final IPacienteCrudRepository iPacienteCrudRepository;

    private final IPacienteMapper iPacienteMapper;


    @Override
    public List<PacienteDto> getAll() {
        List<PacienteDto> pacienteDtos =iPacienteMapper.toPacientesDto(iPacienteCrudRepository.findAll());
        return pacienteDtos;
    }

    @Override
    public Optional<PacienteDto> findById(Long id) {
        return iPacienteCrudRepository.findById(id).map(iPacienteMapper::toPacienteDto);
    }

    @Override
    public PacienteDto save(PacienteDto pacienteDto) {
        PacienteEntity pacienteEntity = iPacienteMapper.toPacienteEntity(pacienteDto);
        return iPacienteMapper.toPacienteDto(iPacienteCrudRepository.save(pacienteEntity));
    }

    @Override
    public void delete(Long id) {
        iPacienteCrudRepository.deleteById(id);
    }

}
