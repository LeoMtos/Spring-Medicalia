package com.medicalia.spring.medicalia.persistence.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.medicalia.spring.medicalia.persistence.entity.DireccionEntity;

public interface IDireccionCrudRepository extends JpaRepository<DireccionEntity, Long>{
    

    @Query("SELECT d FROM DireccionEntity d WHERE d.usuario.id = :usuarioId")
    Optional<DireccionEntity> findDireccionByUserId(Long usuarioId);


}
