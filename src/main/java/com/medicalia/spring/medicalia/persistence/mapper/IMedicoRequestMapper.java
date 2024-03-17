package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;

@Mapper(componentModel = "spring")
public interface IMedicoRequestMapper {

    MedicoRequest toMedicoRequestDto(MedicoEntity medicoEntity);

    MedicoResponse toMedicoResponseDto(MedicoEntity medicoEntity);
    

    MedicoEntity toMedicoEntity(MedicoRequest medicoDto);



    List<MedicoRequest> toMedicosRequestDto(List<MedicoEntity> medicosEntityList);

    List<MedicoResponse> toMedicosResponseDto(List<MedicoEntity> medicosEntityList);


}
