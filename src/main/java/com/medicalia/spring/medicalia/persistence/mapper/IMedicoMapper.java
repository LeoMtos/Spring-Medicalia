package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;

@Mapper(componentModel = "spring")
public interface IMedicoMapper {

    MedicoDto toMedicoDto(MedicoEntity medicoEntity);

    @Mapping(target = "usuario", ignore = true)
    MedicoEntity toMedicoEntity(MedicoDto medicoDto);

    List<MedicoDto> toMedicosDto(List<MedicoEntity> medicosEntityList);


}
