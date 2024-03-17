package com.medicalia.spring.medicalia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoResponse {

    private String nombre;
    private Integer documento;
    private EspecialidadEnum especialidad;
}
