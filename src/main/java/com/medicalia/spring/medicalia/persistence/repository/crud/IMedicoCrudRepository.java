package com.medicalia.spring.medicalia.persistence.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;

public interface IMedicoCrudRepository extends JpaRepository<MedicoEntity, Long>{

    Optional<MedicoEntity> findByNombre(String name);
}
