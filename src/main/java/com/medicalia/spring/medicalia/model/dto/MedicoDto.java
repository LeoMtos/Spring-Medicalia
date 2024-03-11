package com.medicalia.spring.medicalia.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicoDto {

    private Long id;
    private String nombre;
    private Integer documento;
    private EspecialidadEnum especialidad;
    //private DireccionDto direccion;
    private UsuarioDto usuario;
  
}
