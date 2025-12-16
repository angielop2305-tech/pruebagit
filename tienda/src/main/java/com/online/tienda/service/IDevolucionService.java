package com.online.tienda.service;

import com.online.tienda.model.Devolucion;
import com.online.tienda.model.PedidoProducto;

import java.util.List;

public interface IDevolucionService {

    List<Devolucion> buscarTodos();

    Devolucion buscarId(Integer id);

    Devolucion crear(Devolucion devolucion);

    Devolucion actualizar(Integer id, Devolucion devolucion);

    void eliminar(Integer id);

    Devolucion buscarPorPedidoYProducto(Integer idPedido, Integer idProducto);

    PedidoProducto buscarPedidoProductoPorPedidoYProducto(Integer idPedido, Integer idProducto);
}
