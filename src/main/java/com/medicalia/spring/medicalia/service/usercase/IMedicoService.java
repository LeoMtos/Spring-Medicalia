package com.medicalia.spring.medicalia.service.usercase;

import java.util.List;
import java.util.Optional;

import com.medicalia.spring.medicalia.model.dto.MedicoDireccionProjection;
import com.medicalia.spring.medicalia.model.dto.MedicoRequest;
import com.medicalia.spring.medicalia.model.dto.MedicoResponse;

public interface IMedicoService {

List<MedicoResponse> getAll();
Optional<MedicoResponse> findById(Long id);

Optional<MedicoRequest> findByNombre(String nombre);
MedicoRequest save(MedicoRequest medicoDto);
Optional<MedicoRequest> update(MedicoRequest medicoDto, String usuarioDto);
boolean delete(Long id);

Optional<MedicoDireccionProjection> findMedicoDireccionById(Long id);

}
