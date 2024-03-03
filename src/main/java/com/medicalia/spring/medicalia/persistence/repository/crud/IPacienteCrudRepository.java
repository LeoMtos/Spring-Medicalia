package com.medicalia.spring.medicalia.persistence.repository.crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalia.spring.medicalia.persistence.entity.PacienteEntity;

public interface IPacienteCrudRepository extends JpaRepository<PacienteEntity, Long>{

}
