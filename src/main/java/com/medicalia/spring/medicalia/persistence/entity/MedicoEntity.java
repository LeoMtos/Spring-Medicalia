package com.medicalia.spring.medicalia.persistence.entity;

import com.medicalia.spring.medicalia.model.dto.EspecialidadEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="medico")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer documento;

    @Enumerated(EnumType.STRING)
    private EspecialidadEnum especialidad;
    
    // @OneToOne
    // @JoinColumn(name = "direccion_id", updatable = false)
    // private DireccionEntity direccion;

    @OneToOne
    @JoinColumn(name="usuario_id", updatable = false)
    private UsuarioEntity usuario;
}
