package com.medicalia.spring.medicalia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DireccionResponse {

    private String calle;
    private String distrito;
    private String ciudad;
    private Integer numero;
    private String complemento;
}
