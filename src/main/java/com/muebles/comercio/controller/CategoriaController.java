package com.muebles.comercio.controller;

import com.muebles.comercio.model.Categoria;
import com.muebles.comercio.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> listarTodas() {
        return service.listarTodas();
    }

    @PostMapping
    public Categoria guardar(@Valid @RequestBody Categoria categoria) {
        return service.guardar(categoria);
    }
}