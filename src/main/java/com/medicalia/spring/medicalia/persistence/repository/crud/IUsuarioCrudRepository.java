package com.medicalia.spring.medicalia.persistence.repository.crud;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalia.spring.medicalia.persistence.entity.UsuarioEntity;

public interface IUsuarioCrudRepository extends JpaRepository<UsuarioEntity, Long>{

    Optional<UsuarioEntity> findByEmail(String email);
}
