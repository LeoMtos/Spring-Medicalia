package com.medicalia.spring.medicalia.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.persistence.mapper.IUsuarioRequestMapper;
import com.medicalia.spring.medicalia.persistence.repository.crud.IUsuarioCrudRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class UsuarioRepository implements IUsuarioRepository{

    private final IUsuarioCrudRepository iUsuarioCrudRepository;
    private final IUsuarioRequestMapper iUsuarioMapper;

    @Override
    public List<UsuarioRequest> getAll() {
       return iUsuarioMapper.toUsuariosDto(iUsuarioCrudRepository.findAll());
    }

    @Override
    public Optional<UsuarioRequest> findById(Long id) {
        return iUsuarioCrudRepository.findById(id).map(iUsuarioMapper::toUsuarioDto);
    }

    @Override
    public UsuarioRequest save(UsuarioRequest usuarioDto) {
        return  iUsuarioMapper.toUsuarioDto(iUsuarioCrudRepository.save(iUsuarioMapper.toUsuarioEntity(usuarioDto)));
    }

    @Override
    public void delete(Long id) {
        iUsuarioCrudRepository.deleteById(id);
    }

    @Override
    public Optional<UsuarioRequest> findByEmail(String email) {
       return iUsuarioCrudRepository.findByEmail(email).map(iUsuarioMapper::toUsuarioDto);
    }

    @Override
    public Optional<UsuarioRequest> findByNombreUsuario(String userName){
        return iUsuarioCrudRepository.findByNombreUsuario(userName).map(iUsuarioMapper::toUsuarioDto);
    }
    

}
