package com.miguel.apirest.controllers;

import com.miguel.apirest.controllers.dto.AutomovilDto;
import com.miguel.apirest.entity.Automovil;
import com.miguel.apirest.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/automovil")
public class AutomovilController {
    @Autowired
    private AutomovilService automovilService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Automovil> automovilOptional = automovilService.findById(id);
        if (automovilOptional.isPresent()) {
            Automovil automovil = automovilOptional.get();
             AutomovilDto automovilDto = AutomovilDto.builder()
                    .id(automovil.getId())
                    .nombre(automovil.getNombre())
                     .modelo(automovil.getModelo())
                     .color(automovil.getColor())
                     .precio(automovil.getPrecio())
                     .build();
            return ResponseEntity.ok(automovilDto);

        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<AutomovilDto> automovilDtos = automovilService.findAll()
                .stream()
                .map(automovil -> AutomovilDto.builder()
                        .id(automovil.getId())
                        .nombre(automovil.getNombre())
                        .modelo(automovil.getModelo())
                        .color(automovil.getColor())
                        .precio(automovil.getPrecio())

                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(automovilService);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AutomovilDto automovilDto) throws URISyntaxException {
        if (automovilDto.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        automovilService.save(Automovil.builder().nombre(automovilDto.getNombre()).build());
        return ResponseEntity.created(new URI("/api/automovil/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody AutomovilDto automovilDto) {
        Optional<Automovil> automovilOptional = automovilService.findById(id);
        if (automovilOptional.isPresent()) {
            Automovil automovil = automovilOptional.get();
            automovil.setNombre(automovilDto.getNombre());
            automovilService.save(automovil);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (id != null) {
            automovilService.deleteById(id);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }


}
