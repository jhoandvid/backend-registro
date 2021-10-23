package com.hotel.registro.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Table(name = "personas")
@Getter
@Setter
@ToString
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id_persona;
   @NotEmpty (message = "el nombre no puede estar vacio")
    private String pri_nombre;
   @NotEmpty (message = "el usuario no puede estar vacio")
    @Column (unique = true)
    private String username;
    private String seg_nombre;
    private String pri_apellido;
    private String seg_apellido;
    private String razon_social;
    private String direccion;
    @Column (unique = true)
    private String telefono;
    @Column (unique = true)
    private String correo;
    @Column (unique = true)
    private Long identificacion;
    private Character genero;











}
