package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;
import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;
import com.medicalia.spring.medicalia.persistence.mapper.IMedicoMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IMedicoCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MedicoRepository implements IMedicoRepository {


    private final IMedicoCrudRepository iMedicoCrudRepository;

    private final IMedicoMapper iMedicoMapper;


    @Override
    public List<MedicoDto> getAll() {
        List<MedicoDto> medicosDto =iMedicoMapper.toMedicosDto(iMedicoCrudRepository.findAll());
        return medicosDto;
    }

    @Override
    public Optional<MedicoDto> findById(Long id) {
        return iMedicoCrudRepository.findById(id).map(iMedicoMapper::toMedicoDto);
    }

    @Override
    public MedicoDto save(MedicoDto medicoDto) {
        MedicoEntity medicoEntity = iMedicoMapper.toMedicoEntity(medicoDto);
        return iMedicoMapper.toMedicoDto(iMedicoCrudRepository.save(medicoEntity));
        
        //return iMedicoMapper.toMedicoDto(iMedicoCrudRepository.save(medicoDto));
    }

    @Override
    public void delete(Long id) {
        iMedicoCrudRepository.deleteById(id);
    }

    @Override
    public Optional<MedicoDto> findByNombre(String name) {
       return iMedicoCrudRepository.findByNombre(name).map(iMedicoMapper::toMedicoDto);
    }

}
