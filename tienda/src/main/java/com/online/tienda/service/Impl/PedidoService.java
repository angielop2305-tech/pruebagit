package com.online.tienda.service.Impl;


import com.online.tienda.model.Pedido;
import com.online.tienda.model.PedidoProducto;
import com.online.tienda.model.Producto;
import com.online.tienda.repository.PedidoRepository;
import com.online.tienda.repository.ProductoRepository;
import com.online.tienda.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService implements IPedidoService {

private PedidoRepository pedidoRepo;
private ProductoRepository productoRepo;


@Autowired
public PedidoService(PedidoRepository pedidoRepo, ProductoRepository productoRepo) {
    this.pedidoRepo = pedidoRepo;
    this.productoRepo = productoRepo;
}

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoRepo.findAll();
    }

    @Override
    public Pedido buscarId(Integer id) {
        return pedidoRepo.findById(id).get();
    }

    @Override
    public Pedido crear(Pedido pedido) {

    BigDecimal total = BigDecimal.valueOf(0);

    for(PedidoProducto pp:pedido.getProductos()) {

        Producto producto = productoRepo.findById(pp.getProducto().getId()).orElseThrow(()
                -> new RuntimeException("Producto no encontrado" + pp.getProducto().getId()));

        if (producto.getStock()< pp.getCantidad()) {
            throw new RuntimeException("Cantidad no encontrada");
        }

        int nuevoStock = producto.getStock() - pp.getCantidad();
        producto.setStock(nuevoStock);

        if (nuevoStock==0) {
            producto.setEstado("Vendido");
        } else {
            producto.setEstado("Disponible");
        }

        productoRepo.save(producto);

        pp.setProducto(producto);
        pp.setPedido(pedido);

        total = total.add(pp.getProducto().getPrecio().multiply(BigDecimal.valueOf(pp.getCantidad())));
    }

pedido.setTotal(total);
        return  pedidoRepo.save(pedido);
    }

    @Override
    public Pedido actualizar(Integer id, Pedido pedido) {
        Pedido existente = pedidoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el pedido con el id: " + id));

        existente.setFecha(pedido.getFecha());
        existente.setMetodoPago(pedido.getMetodoPago());
        existente.setCliente(pedido.getCliente());

        return pedidoRepo.save(existente);
    }


    @Override
    public String devolverProducto(Integer idPedido, Integer idProducto, int cantidad) {

        Producto producto = productoRepo.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Pedido pedido = pedidoRepo.findById(idPedido)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));


        producto.setStock(producto.getStock() + cantidad);
        productoRepo.save(producto);


        BigDecimal totalDevolucion = producto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
        pedido.setTotal(pedido.getTotal().subtract(totalDevolucion));
        pedidoRepo.save(pedido);

        return "Devolución realizada: " + cantidad + " " + producto.getNombre();
    }


    @Override
    public void eliminar(Integer id) {
    pedidoRepo.deleteById(id);
    }
}
