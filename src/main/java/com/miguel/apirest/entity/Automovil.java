package com.miguel.apirest.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Automovil")
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String modelo;
    private String color;
    private BigDecimal precio;
@ManyToOne
@JoinColumn(name = "id_persona",nullable = false)
    private Persona persona;
}
