package com.miguel.apirest.controllers.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutomovilDto {
    private Long id;
    private String nombre;
    private String modelo;
    private String color;
    private BigDecimal precio;
}
