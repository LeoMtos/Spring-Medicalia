package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioRequestMapper {

    UsuarioRequest toUsuarioDto(UsuarioEntity usuarioEntity);

    @Mapping(target = "medicoEntity", ignore = true)
    @Mapping(target = "pacienteEntity", ignore = true)
    @Mapping(target = "direccioneEntity", ignore = true)
    UsuarioEntity toUsuarioEntity(UsuarioRequest usuarioDto);

    List<UsuarioRequest> toUsuariosDto(List<UsuarioEntity> usuariosEntityList);
    
}
