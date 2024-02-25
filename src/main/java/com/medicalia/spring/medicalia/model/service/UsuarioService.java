package com.medicalia.spring.medicalia.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.UsuarioDto;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@Service
public class UsuarioService implements IUsuarioService{
    
    private final IUsuarioRepository iUsuarioRepository;


    @Override
    public List<UsuarioDto> getAll() {
           
       return iUsuarioRepository.getAll();
    }

    @Override
    public Optional<UsuarioDto> findById(Long id) {
        return iUsuarioRepository.findById(id);
    }

    @Override
    public Optional<UsuarioDto> findByEmail(String email) {
        return iUsuarioRepository.findByEmail(email);
    }


    @Override
    public UsuarioDto save(UsuarioDto usuarioDto) {
        return iUsuarioRepository.save(usuarioDto);
    }

    @Override
    public Optional<UsuarioDto> update(UsuarioDto usuarioDto, Long id) {

        if (iUsuarioRepository.findById(id).isEmpty()) {
            return Optional.empty();
        }
        usuarioDto.setId(id);
        return Optional.of(iUsuarioRepository.save(usuarioDto));
    }

    @Override
    public boolean delete(Long id) {
        Optional<UsuarioDto> usuOptional= iUsuarioRepository.findById(id);

        if( usuOptional.isPresent()){
            iUsuarioRepository.delete(id);
            return true;
        }
        return false;
    }

}
