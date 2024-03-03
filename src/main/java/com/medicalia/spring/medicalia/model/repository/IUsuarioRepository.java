package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;


public interface IUsuarioRepository {

    List<UsuarioDto> getAll();
    Optional<UsuarioDto> findById(Long id);
    UsuarioDto save(UsuarioDto usuarioDto);
    void delete(Long id);
    Optional<UsuarioDto> findByEmail(String email);
    Optional<UsuarioDto> findByNombreUsuario(String userName);

}
