package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.exception.DireccionNotFoundException;
import com.medicalia.spring.medicalia.exception.UsuarioNotFoundException;
import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.model.dto.DireccionResponse;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DireccionService implements IDireccionService {

    private final IDireccionRepository iDireccionRepository;
    private final IUsuarioRepository IUsuarioRepository;

    @Override
    public List<DireccionResponse> getAll() {
        return iDireccionRepository.getAll();
    }

    @Override
    public Optional<DireccionResponse> findById(Long id) {
        return iDireccionRepository.findById(id);
    }

    @Override
    public Optional<DireccionRequest> update(DireccionRequest direccionDto, String usuarioDto) {
        Optional<UsuarioRequest> usuOptional=IUsuarioRepository.findByNombreUsuario(usuarioDto);

        if(usuOptional.isPresent()){
            Optional<DireccionRequest> direccOptional = iDireccionRepository.findDireccionByUserId(usuOptional.get().getId());
            if(direccOptional.isPresent()){

                direccOptional.get().setCalle(direccOptional.get().getCalle() != direccionDto.getCalle() ? direccionDto.getCalle() : direccOptional.get().getCalle() );
                direccOptional.get().setComplemento(direccOptional.get().getComplemento() != direccionDto.getComplemento()? direccionDto.getComplemento(): direccOptional.get().getComplemento());
                direccOptional.get().setCiudad(direccOptional.get().getCiudad() != direccionDto.getCiudad() ? direccionDto.getCiudad(): direccOptional.get().getCiudad());
                direccOptional.get().setDistrito(direccOptional.get().getDistrito() != direccionDto.getDistrito() ? direccionDto.getDistrito() : direccOptional.get().getDistrito());
                direccOptional.get().setNumero(direccOptional.get().getNumero() != direccionDto.getNumero() ? direccionDto.getNumero() : direccOptional.get().getNumero());
                
            return Optional.of(iDireccionRepository.save(direccOptional.get()));
            }
        
                throw new DireccionNotFoundException();
        }
        else{
            throw new UsuarioNotFoundException();
        }
        
    }

    @Override
    public DireccionRequest save(DireccionRequest direccionDto) {

        return iDireccionRepository.save(direccionDto);
    }

    @Override
    public Optional<DireccionRequest> findDireccionByUserId(Long id) {
       return iDireccionRepository.findDireccionByUserId(id);
    }

    


}
