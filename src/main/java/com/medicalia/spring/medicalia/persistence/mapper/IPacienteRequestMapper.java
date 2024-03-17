package com.medicalia.spring.medicalia.persistence.mapper;


import java.util.List;

import org.mapstruct.Mapper;

import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;

@Mapper(componentModel = "spring")
public interface IPacienteRequestMapper {

    PacienteRequest toPacienteDto(PacienteEntity pacienteEntity);
    
    PacienteEntity toPacienteEntity(PacienteRequest pacienteDto);

    List<PacienteRequest> toPacientesDto(List<PacienteEntity> pacieteEntityList);
}
