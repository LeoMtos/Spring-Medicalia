package com.medicalia.spring.medicalia.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.persistence.entity.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioMapper {

    UsuarioDto toUsuarioDto(UsuarioEntity usuarioEntity);

    UsuarioEntity toUsuarioEntity(UsuarioDto usuarioDto);

    List<UsuarioDto> toUsuariosDto(List<UsuarioEntity> usuariosEntityList);
    
}
