package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;


import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.persistence.entity.DireccionEntity;

@Mapper(componentModel = "spring")
public interface IDireccionRequestMapper {

    DireccionRequest toDireccionDto(DireccionEntity direccionEntity);

    DireccionEntity toDireccionEntity(DireccionRequest direccionDto);

    List<DireccionRequest> toDireccionsDto(List<DireccionEntity> direccionEntityList);

}
