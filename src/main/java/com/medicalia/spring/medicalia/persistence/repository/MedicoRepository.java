package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.MedicoDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;
import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;
import com.medicalia.spring.medicalia.persistence.mapper.IMedicoRequestMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IMedicoCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class MedicoRepository implements IMedicoRepository {


    private final IMedicoCrudRepository iMedicoCrudRepository;

    private final IMedicoRequestMapper iMedicoMapper;


    @Override
    public List<MedicoResponse> getAll() {
        return iMedicoMapper.toMedicosResponseDto(iMedicoCrudRepository.findAll());
    }

    @Override
    public Optional<MedicoResponse> findById(Long id) {
        return iMedicoCrudRepository.findById(id).map(iMedicoMapper::toMedicoResponseDto);
    }

    @Override
    public MedicoRequest save(MedicoRequest medicoDto) {
        MedicoEntity medicoEntity = iMedicoMapper.toMedicoEntity(medicoDto);
        return iMedicoMapper.toMedicoRequestDto(iMedicoCrudRepository.save(medicoEntity));
        
        //return iMedicoMapper.toMedicoDto(iMedicoCrudRepository.save(medicoDto));
    }

    @Override
    public void delete(Long id) {
        iMedicoCrudRepository.deleteById(id);
    }

    @Override
    public Optional<MedicoRequest> findByNombre(String name) {
       return iMedicoCrudRepository.findByNombre(name).map(iMedicoMapper::toMedicoRequestDto);
    }

    @Override
    public Optional<MedicoRequest> findMedicoByUserId(Long id) {
        return iMedicoCrudRepository.findMedicoByUserId(id).map(iMedicoMapper::toMedicoRequestDto);
    }

    @Override
    public Optional<MedicoDireccionProjection> findMedicoDireccionByUserId(Long id) {
       return iMedicoCrudRepository.findMedicoAndDireccionByUserId(id);
    }

}
