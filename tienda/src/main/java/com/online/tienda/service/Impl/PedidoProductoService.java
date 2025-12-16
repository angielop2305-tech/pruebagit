package com.online.tienda.service.Impl;


import com.online.tienda.model.Cliente;
import com.online.tienda.model.PedidoProducto;
import com.online.tienda.repository.PedidoProductoRepository;
import com.online.tienda.service.IPedidoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductoService implements IPedidoProductoService {


    private final PedidoProductoRepository pedidoProductoRepo;


    @Autowired
    public PedidoProductoService(PedidoProductoRepository pedidoProductoRepo) {
        this.pedidoProductoRepo = pedidoProductoRepo;

    }

    @Override
    public List<PedidoProducto> buscarTodos() {
        return pedidoProductoRepo.findAll();
    }

    @Override
    public PedidoProducto buscarId(Integer id) {
        return pedidoProductoRepo.findById(id).get();
    }

    @Override
    public PedidoProducto crear(PedidoProducto pedidoProducto) {
        return pedidoProductoRepo.save(pedidoProducto);
    }

    @Override
    public PedidoProducto actualizar(Integer id, PedidoProducto pedidoProducto) {
        PedidoProducto existente = pedidoProductoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el pedido-producto con el id: " + id));

        existente.setCantidad(pedidoProducto.getCantidad());
        existente.setPedido(pedidoProducto.getPedido());
        existente.setProducto(pedidoProducto.getProducto());

        return pedidoProductoRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoProductoRepo.deleteById(id);
    }
}
