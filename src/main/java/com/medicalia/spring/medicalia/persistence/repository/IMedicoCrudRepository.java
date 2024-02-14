package com.medicalia.spring.medicalia.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalia.spring.medicalia.persistence.entity.MedicoEntity;

public interface IMedicoCrudRepository extends JpaRepository<MedicoEntity, Long>{

}
