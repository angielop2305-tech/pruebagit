package com.online.tienda.service;

import com.online.tienda.model.Cliente;
import com.online.tienda.model.PedidoProducto;

import java.util.List;

public interface IPedidoProductoService {

    List<PedidoProducto> buscarTodos();

    PedidoProducto buscarId (Integer id);

    public PedidoProducto crear (PedidoProducto pedidoProducto);

    PedidoProducto actualizar (Integer id, PedidoProducto pedidoProducto);

    public void eliminar (Integer id);
}
