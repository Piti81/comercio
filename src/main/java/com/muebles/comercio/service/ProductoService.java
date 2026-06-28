package com.muebles.comercio.service;

import com.muebles.comercio.exception.ProductoNoEncontradoException;
import com.muebles.comercio.model.Producto;
import com.muebles.comercio.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductoNoEncontradoException(
                                "No existe el producto con id " + id));
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto actualizar(Long id, Producto producto) {

        obtenerPorId(id); // Verifica que exista

        producto.setId(id);

        return repository.save(producto);
    }

    public void eliminar(Long id) {

        obtenerPorId(id); // Verifica que exista

        repository.deleteById(id);
    }
}