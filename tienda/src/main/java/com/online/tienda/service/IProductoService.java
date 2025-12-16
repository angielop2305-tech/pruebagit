package com.online.tienda.service;

import com.online.tienda.model.Producto;

import java.util.List;

public interface IProductoService {

    List<Producto> buscarTodos();

    Producto buscarId (Integer id);

    public Producto crear (Producto producto);

    Producto actualizar (Integer id, Producto producto);

    public void eliminar (Integer id);
}


