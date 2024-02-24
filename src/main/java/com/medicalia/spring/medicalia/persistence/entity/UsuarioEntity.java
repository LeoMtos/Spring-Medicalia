package com.medicalia.spring.medicalia.persistence.entity;

import com.medicalia.spring.medicalia.model.dto.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre_usuario")
    private String nombreUsuario;
    
    private String email;
    
    private String contrasenia;
    
    @Enumerated(EnumType.STRING)
    private ERole rol;

    
}
