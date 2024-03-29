package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.exception.MedicoNotFoundException;
import com.medicalia.spring.medicalia.exception.UsuarioNotFoundException;
import com.medicalia.spring.medicalia.model.dto.MedicoDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.model.dto.UsuarioRequest;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;
import com.medicalia.spring.medicalia.model.repository.IUsuarioRepository;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private final IMedicoRepository iMedicoRepository;
    private final IUsuarioRepository iUsuarioRepository;


    @Override
    public List<MedicoResponse> getAll() {
        return iMedicoRepository.getAll();
    }

    @Override
    public Optional<MedicoResponse> findById(Long id) {
        return iMedicoRepository.findById(id);
    }

    @Override
    public MedicoRequest save(MedicoRequest medicoDto) {
      
        return iMedicoRepository.save(medicoDto);
    }

    @Override
    public Optional<MedicoRequest> update(MedicoRequest medicoDto, String usuarioDto) {

        Optional<UsuarioRequest> usuOptional=iUsuarioRepository.findByNombreUsuario(usuarioDto);
        
         if(usuOptional.isPresent()){
            Optional<MedicoRequest> medicOptional = iMedicoRepository.findMedicoByUserId(usuOptional.get().getId());
            
            if(medicOptional.isPresent()){

                medicOptional.get().setNombre(medicOptional.get().getNombre() != medicoDto.getNombre() ? medicoDto.getNombre() : medicOptional.get().getNombre());
                medicOptional.get().setDocumento(medicOptional.get().getDocumento() != medicoDto.getDocumento() ? medicoDto.getDocumento() :medicOptional.get().getDocumento() );
                medicOptional.get().setEspecialidad(medicOptional.get().getEspecialidad() != medicoDto.getEspecialidad() ? medicoDto.getEspecialidad() : medicOptional.get().getEspecialidad());
                
            return Optional.of(iMedicoRepository.save(medicOptional.get()));
            }
        
                throw new MedicoNotFoundException();
        }
        else{
            throw new UsuarioNotFoundException();
        }
      
    }


    @Override
    public boolean delete(Long id) {
       Optional<MedicoResponse> medicoResponse = iMedicoRepository.findById(id);

       if(medicoResponse.isPresent()){
        iMedicoRepository.delete(id);
        return true;
       }

       return false;

       
    }

    @Override
    public Optional<MedicoRequest> findByNombre(String nombre) {
    
        return iMedicoRepository.findByNombre(nombre);    
    }

    @Override
    public Optional<MedicoDireccionProjection> findMedicoDireccionById(Long id) {
       return iMedicoRepository.findMedicoDireccionByUserId(id);
    }

    


}
