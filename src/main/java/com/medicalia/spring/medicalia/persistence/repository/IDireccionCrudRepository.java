package com.medicalia.spring.medicalia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalia.spring.medicalia.persistence.entity.DireccionEntity;

public interface IDireccionCrudRepository extends JpaRepository<DireccionEntity, Long>{
    

}
