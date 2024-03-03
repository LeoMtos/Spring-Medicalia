package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.persistence.mapper.IUsuarioMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IUsuarioCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UsuarioRepository implements IUsuarioRepository{

    private final IUsuarioCrudRepository iUsuarioCrudRepository;
    private final IUsuarioMapper iUsuarioMapper;

    @Override
    public List<UsuarioDto> getAll() {
       return iUsuarioMapper.toUsuariosDto(iUsuarioCrudRepository.findAll());
    }

    @Override
    public Optional<UsuarioDto> findById(Long id) {
        return iUsuarioCrudRepository.findById(id).map(iUsuarioMapper::toUsuarioDto);
    }

    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        return  iUsuarioMapper.toUsuarioDto(iUsuarioCrudRepository.save(iUsuarioMapper.toUsuarioEntity(usuarioDto)));
    }

    @Override
    public void delete(Long id) {
        iUsuarioCrudRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioDto> findByEmail(String email) {
       return iUsuarioCrudRepository.findByEmail(email).map(iUsuarioMapper::toUsuarioDto);
    }

    @Override
    public Optional<UsuarioDto> findByNombreUsuario(String userName){
        return iUsuarioCrudRepository.findByNombreUsuario(userName).map(iUsuarioMapper::toUsuarioDto);
    }
    

}
