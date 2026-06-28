package com.muebles.comercio.service;

import com.muebles.comercio.exception.ProductoNoEncontradoException;
import com.muebles.comercio.exception.StockInsuficienteException;
import com.muebles.comercio.model.LineaPedido;
import com.muebles.comercio.model.Pedido;
import com.muebles.comercio.model.Producto;
import com.muebles.comercio.repository.PedidoRepository;
import com.muebles.comercio.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.productoRepository = productoRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido guardar(Pedido pedido) {

       
        pedido.setFecha(LocalDate.now());

System.out.println(">>> Fecha asignada: " + pedido.getFecha());

        System.out.println("Fecha asignada: " + pedido.getFecha());

        for (LineaPedido linea : pedido.getLineas()) {

            Producto producto = productoRepository.findById(
                    linea.getProducto().getId()
            ).orElseThrow(() ->
                    new ProductoNoEncontradoException(
                            "No existe el producto con id " + linea.getProducto().getId()));

            if (producto.getStock() < linea.getCantidad()) {
                throw new StockInsuficienteException(
                        "Stock insuficiente para el producto: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - linea.getCantidad());

            productoRepository.save(producto);

            linea.setPedido(pedido);
        }

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        System.out.println("Fecha guardada: " + pedidoGuardado.getFecha());

        return pedidoGuardado;
    }
}

