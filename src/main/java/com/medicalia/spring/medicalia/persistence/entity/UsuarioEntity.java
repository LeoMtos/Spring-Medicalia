package com.medicalia.spring.medicalia.persistence.entity;

import com.medicalia.spring.medicalia.model.dto.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

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
    private ERole role;

    @OneToOne(mappedBy ="usuario")
    private MedicoEntity medicoEntity;

}
