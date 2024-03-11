package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;
import com.medicalia.spring.medicalia.persistence.entity.DireccionEntity;
import com.medicalia.spring.medicalia.persistence.mapper.IDireccionMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IDireccionCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class DireccionRepository implements IDireccionRepository {

    private final IDireccionCrudRepository iDireccionCrudRepository;
    private final IDireccionMapper iDireccionMapper;

    @Override
    public List<DireccionDto> getAll() {
        return iDireccionMapper.toDireccionsDto(iDireccionCrudRepository.findAll());
    }

    @Override
    public Optional<DireccionDto> findById(Long id) {
        return iDireccionCrudRepository.findById(id).
        map(directionEntity-> iDireccionMapper.toDireccionDto(directionEntity));
    }
    
    @Override
    public DireccionDto save(DireccionDto medicoDto) {
        DireccionEntity direccion = iDireccionMapper.toDireccionEntity(medicoDto);
        return iDireccionMapper.toDireccionDto(iDireccionCrudRepository.save(direccion));
    }

    @Override
    public Optional<DireccionDto> findDireccionByUserId(Long id) {
       return iDireccionCrudRepository.findDireccionByUserId(id).map(iDireccionMapper::toDireccionDto);
    }


}
