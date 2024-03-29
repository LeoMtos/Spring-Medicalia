package com.medicalia.spring.medicalia.persistence.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicalia.spring.medicalia.model.dto.MedicoDireccionProjection;
import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;

public interface IMedicoCrudRepository extends JpaRepository<MedicoEntity, Long>{

    Optional<MedicoEntity> findByNombre(String name);

    @Query("SELECT d FROM MedicoEntity d WHERE d.usuario.id = :usuarioId")
    Optional<MedicoEntity> findMedicoByUserId(Long usuarioId);

    @Query(value = "SELECT m.nombre AS nombre, m.especialidad AS especialidad, " +
        "d.calle AS calle, d.numero AS numero, d.ciudad AS ciudad , d.distrito AS distrito " +
        "FROM medico m " +
        "INNER JOIN direccion d ON d.usuario_id = m.usuario_id " +
        "WHERE m.usuario_id = :usuarioId", nativeQuery = true)
    Optional<MedicoDireccionProjection> findMedicoAndDireccionByUserId(Long usuarioId);

}
