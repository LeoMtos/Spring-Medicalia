package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.exception.PacienteNotFoundException;
import com.medicalia.spring.medicalia.exception.UsuarioNotFoundException;
import com.medicalia.spring.medicalia.model.dto.PacienteDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.PacienteRequest;
import com.medicalia.spring.medicalia.model.dto.PacienteResponse;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IPacienteRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.service.usercase.IPacienteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository iPacienteRepository;
    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public List<PacienteResponse> getAll() {
        return iPacienteRepository.getAll();
    }

    @Override
    public Optional<PacienteResponse> findById(Long id) {
        return iPacienteRepository.findById(id);
    }

    @Override
    public PacienteRequest save(PacienteRequest pacienteDto) {
        return iPacienteRepository.save(pacienteDto);
    }

    @Override
    public Optional<PacienteRequest> update(PacienteRequest pacienteDto, String usuarioRequest) {

         Optional<UsuarioRequest> usuOptional=iUsuarioRepository.findByNombreUsuario(usuarioRequest);

         if(usuOptional.isPresent()){
            Optional<PacienteRequest> pacienteRequest = iPacienteRepository.findPacienteByUserId(usuOptional.get().getId());
            
            if(pacienteRequest.isPresent()){
                

            return Optional.of(iPacienteRepository.save(pacienteRequest.get()));
            }
        
                throw new PacienteNotFoundException();
        }
        else{
            throw new UsuarioNotFoundException();
        }
    }
    

    @Override
    public boolean delete(Long id) {
       return false;
    }

    @Override
    public Optional<PacienteDireccionProjection> findPacienteDireccionById(Long id) {
       return iPacienteRepository.findPacienteDireccionByUserId(id);
    }


}
