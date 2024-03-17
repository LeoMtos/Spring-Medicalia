package com.medicalia.spring.medicalia.model.repository;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;


public interface IUsuarioRepository {

    List<UsuarioRequest> getAll();
    Optional<UsuarioRequest> findById(Long id);
    UsuarioRequest save(UsuarioRequest usuarioDto);
    void delete(Long id);
    Optional<UsuarioRequest> findByEmail(String email);
    Optional<UsuarioRequest> findByNombreUsuario(String userName);

}
