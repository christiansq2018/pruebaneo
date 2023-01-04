package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="cliente", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idCliente;
    private String contrasena;
    private String estado;
    //@OneToOne(cascade = {CascadeType.ALL})
    @OneToOne
    @JoinColumn(name = "idpersona")
    private Persona persona;


}
