package com.medicalia.spring.medicalia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;
import com.medicalia.spring.medicalia.service.usercase.IMedicoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private final IMedicoRepository iMedicoRepository;


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
    public Optional<MedicoRequest> update(MedicoRequest medicoDto) {
        Optional<MedicoResponse> medicoDto2 = iMedicoRepository.findById(medicoDto.getId());


        if (medicoDto2.isEmpty()) {
            return Optional.empty();
        }
        medicoDto.setNombre(medicoDto.getNombre()== null ? medicoDto2.get().getNombre() : medicoDto.getNombre());
        medicoDto.setDocumento(medicoDto.getDocumento()==null ? medicoDto2.get().getDocumento() : medicoDto.getDocumento());
        medicoDto.setEspecialidad(medicoDto.getEspecialidad() == null ? medicoDto2.get().getEspecialidad() : medicoDto.getEspecialidad());
        return Optional.of(iMedicoRepository.save(medicoDto));
    }
    

    @Override
    public boolean delete(Long id) {
       return false;
    }

    @Override
    public Optional<MedicoRequest> findByNombre(String nombre) {
    
        return iMedicoRepository.findByNombre(nombre);    
    }


}
