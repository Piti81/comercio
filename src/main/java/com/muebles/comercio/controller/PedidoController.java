package com.muebles.comercio.controller;

import com.muebles.comercio.model.Pedido;
import com.muebles.comercio.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public Pedido guardar(@Valid @RequestBody Pedido pedido) {
        return service.guardar(pedido);
    }
}