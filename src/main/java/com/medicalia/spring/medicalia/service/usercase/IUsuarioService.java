package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;

public interface IUsuarioService {

List<UsuarioDto> getAll();
Optional<UsuarioDto> findById(Long id);
UsuarioDto save(UsuarioDto usuarioDto);
Optional<UsuarioDto> update(UsuarioDto usuarioDto, Long id);
boolean delete(Long id);
Optional<UsuarioDto> findByEmail(String email);
Optional<UsuarioDto> findByName(String name);

}
