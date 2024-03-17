package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.ERole;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;

public interface IUsuarioService {

List<UsuarioRequest> getAll();
Optional<UsuarioRequest> findById(Long id);
UsuarioRequest save(UsuarioRequest usuarioDto, ERole role);
Optional<UsuarioRequest> update(UsuarioRequest usuarioDto, Long id);
boolean delete(Long id);
Optional<UsuarioRequest> findByEmail(String email);
Optional<UsuarioRequest> findByName(String name);

}
