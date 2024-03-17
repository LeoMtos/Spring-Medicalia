package com.medicalia.spring.medicalia.persistence.entity;


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
@Table(name="direccion")
public class DireccionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String calle;
    private String distrito;
    private String ciudad;
    private Integer numero;
    private String complemento;

    // @OneToOne(mappedBy ="direccion")
    // private MedicoEntity medicoEntity; 

    // @OneToOne(mappedBy ="direccion")
    // private PacienteEntity pacienteEntity; 
   
    @OneToOne
    @JoinColumn(name="usuario_id",updatable = false)
    private UsuarioEntity usuario;
}
