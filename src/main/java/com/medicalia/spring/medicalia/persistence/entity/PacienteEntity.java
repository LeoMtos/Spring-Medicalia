package com.medicalia.spring.medicalia.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="paciente")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String genero;

    @Column(name="telefono")
    private Integer numeroTelefono;

    // @OneToOne
    // @JoinColumn(name = "direccion_id")
    // private DireccionEntity direccion;

    @OneToOne
    @JoinColumn(name="usuario_id",updatable = false)
    private UsuarioEntity usuario;


}
