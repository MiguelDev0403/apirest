package com.miguel.apirest.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuario")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nombre;
private String apellido;
private String email;
@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Automovil>automovilList=new ArrayList<>();


}
