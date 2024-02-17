package com.miguel.apirest.controllers.dto;

import com.miguel.apirest.entity.Automovil;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private List<Automovil>automovilList = new ArrayList<>();
}

