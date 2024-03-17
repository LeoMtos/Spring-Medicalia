package com.medicalia.spring.medicalia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionRequest {

    private Long id;
    private String calle;
    private String distrito;
    private String ciudad;
    private Integer numero;
    private String complemento;
    private UsuarioRequest usuario;
    
}
