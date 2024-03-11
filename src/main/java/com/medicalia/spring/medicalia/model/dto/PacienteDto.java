package com.medicalia.spring.medicalia.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class PacienteDto {
    
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String genero;
    private Integer numeroTelefono;
    //private DireccionDto direccion;
    private UsuarioDto usuario;
    
}
