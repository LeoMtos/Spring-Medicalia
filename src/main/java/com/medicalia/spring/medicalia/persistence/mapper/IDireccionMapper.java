package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medicalia.spring.medicalia.model.dto.DireccionDto;
import com.medicalia.spring.medicalia.persistence.entity.DireccionEntity;

@Mapper(componentModel = "spring")
public interface IDireccionMapper {

    DireccionDto toDireccionDto(DireccionEntity direccionEntity);

    @Mapping(target = "medicoEntity", ignore= true)
    @Mapping(target = "pacienteEntity", ignore= true)
    DireccionEntity toDireccionEntity(DireccionDto direccionDto);

    List<DireccionDto> toDireccionsDto(List<DireccionEntity> direccionEntityList);

}
