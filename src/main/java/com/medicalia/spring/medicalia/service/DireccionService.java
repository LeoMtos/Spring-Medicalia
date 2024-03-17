package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.exception.DireccionNotFoundException;
import com.medicalia.spring.medicalia.exception.UsuarioNotFoundException;
import com.medicalia.spring.medicalia.model.dto.DireccionRequest;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IDireccionRepository;
import com.medicalia.spring.medicalia.service.usercase.IDireccionService;
import com.medicalia.spring.medicalia.service.usercase.IUsuarioService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DireccionService implements IDireccionService {

    private final IDireccionRepository iDireccionRepository;
    private final IUsuarioService iUsuarioService;

    @Override
    public List<DireccionRequest> getAll() {
        return iDireccionRepository.getAll();
    }

    @Override
    public Optional<DireccionRequest> findById(Long id) {
        return iDireccionRepository.findById(id);
    }

    @Override
    public Optional<DireccionRequest> update(DireccionRequest direccionDto, String usuarioDto) {
        Optional<UsuarioRequest> usuOptional=iUsuarioService.findByName(usuarioDto);

        if(usuOptional.isPresent()){
            Optional<DireccionRequest> direccOptional = iDireccionRepository.findDireccionByUserId(usuOptional.get().getId());
            if(direccOptional.isPresent()){
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
