package com.miguel.apirest.controllers;

import com.miguel.apirest.controllers.dto.PersonaDto;
import com.miguel.apirest.entity.Persona;
import com.miguel.apirest.service.PersonaService;
import com.miguel.apirest.service.impl.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
   private PersonaService psi;
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Persona> personaOptional = psi.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
            PersonaDto personaDTO = PersonaDto.builder()
                    .id(persona.getId())
                    .nombre(persona.getNombre())
                    .apellido(persona.getApellido())
                    .email(persona.getEmail())
                    .automovilList(persona.getAutomovilList())
                    .build();
            return ResponseEntity.ok(personaDTO);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PersonaDto> personaDtoList = psi.findAll()
                .stream()
                .map(persona -> PersonaDto.builder()
                        .id(persona.getId())
                        .nombre(persona.getNombre())
                        .apellido(persona.getApellido())
                        .email(persona.getEmail())
                        .automovilList(persona.getAutomovilList())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(personaDtoList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PersonaDto personaDto) throws URISyntaxException {
        if (personaDto.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        psi.save(Persona.builder().nombre(personaDto.getNombre()).build());
        return ResponseEntity.created(new URI("/api/maker/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody PersonaDto personaDto) {
        Optional<Persona> personaOptional = psi.findById(id);
        if (personaOptional.isPresent()) {
            Persona maker = personaOptional.get();
            personaDto.setNombre(personaDto.getNombre());
            psi.save(maker);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            psi.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
