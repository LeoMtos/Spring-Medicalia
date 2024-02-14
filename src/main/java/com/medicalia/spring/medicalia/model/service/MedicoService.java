package com.medicalia.spring.medicalia.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.medicalia.spring.medicalia.model.dto.MedicoDto;
import com.medicalia.spring.medicalia.model.repository.IMedicoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private final IMedicoRepository iMedicoRepository;

    @Override
    public List<MedicoDto> getAll() {
        return iMedicoRepository.getAll();
    }

    @Override
    public Optional<MedicoDto> findById(Long id) {
        return iMedicoRepository.findById(id);
    }

    @Override
    public MedicoDto save(MedicoDto medicoDto) {
        return iMedicoRepository.save(medicoDto);
    }

    @Override
    public Optional<MedicoDto> update(MedicoDto medicoDto) {
        Optional<MedicoDto> medicoDto2 = iMedicoRepository.findById(medicoDto.getId());


        if (medicoDto2.isEmpty()) {
            return Optional.empty();
        }
        medicoDto.setEmail(medicoDto.getEmail()== null ? medicoDto2.get().getEmail() : medicoDto.getEmail());
        medicoDto.setNombre(medicoDto.getNombre()== null ? medicoDto2.get().getNombre() : medicoDto.getNombre());
        medicoDto.setDocumento(medicoDto.getDocumento()==null ? medicoDto2.get().getDocumento() : medicoDto.getDocumento());
        medicoDto.setDireccion(medicoDto.getDireccion() == null ? medicoDto2.get().getDireccion() : medicoDto.getDireccion());
        medicoDto.setEspecialidad(medicoDto.getEspecialidad() == null ? medicoDto2.get().getEspecialidad() : medicoDto.getEspecialidad());
        return Optional.of(iMedicoRepository.save(medicoDto));
    }
    

    @Override
    public boolean delete(Long id) {
       return false;
    }


}
