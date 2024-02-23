package com.medicalia.spring.medicalia.persistence.mapper;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medicalia.spring.medicalia.model.dto.PacienteDto;
import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;

@Mapper(componentModel = "spring")
public interface IPacienteMapper {
 
    PacienteDto toPacienteDto(PacienteEntity pacienteEntity);

    @Mapping(target = "direccion", ignore = true)
    PacienteEntity toPacienteEntity(PacienteDto pacienteDto);

    List<PacienteDto> toPacientesDto(List<PacienteEntity> pacieteEntityList);
}
