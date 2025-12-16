package com.online.tienda.service;

import com.online.tienda.model.Pedido;

import java.util.List;

public interface IPedidoService {

    List<Pedido> buscarTodos();

    Pedido buscarId (Integer id);

    public Pedido crear (Pedido pedido);

    Pedido actualizar (Integer id, Pedido pedido);

    String devolverProducto(Integer idPedido, Integer idProducto, int cantidad);

    public void eliminar (Integer id);
}
