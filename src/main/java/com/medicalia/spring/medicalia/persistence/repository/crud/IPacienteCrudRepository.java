package com.medicalia.spring.medicalia.persistence.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medicalia.spring.medicalia.model.dto.PacienteDireccionProjection;
import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;

public interface IPacienteCrudRepository extends JpaRepository<PacienteEntity, Long>{

@Query("SELECT d FROM PacienteEntity d WHERE d.usuario.id = :usuarioId")
    Optional<PacienteEntity> findPacienteByUserId(Long usuarioId);

@Query(value = "SELECT p.nombre AS nombre, p.apellido AS apellido, p.telefono AS telefono, " +
        "d.calle AS calle, d.numero AS numero, d.ciudad AS ciudad " +
        "FROM paciente p " +
        "INNER JOIN direccion d ON d.usuario_id = p.usuario_id " +
        "WHERE p.usuario_id = :usuarioId", nativeQuery = true)
Optional<PacienteDireccionProjection> findPacienteAndDireccionByUserId(Long usuarioId);

}
