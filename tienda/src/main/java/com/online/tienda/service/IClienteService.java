package com.online.tienda.service;

import com.online.tienda.model.Cliente;

import java.util.List;

public interface IClienteService {

    List<Cliente> buscarTodos();

    Cliente buscarId (Integer id);

    public Cliente crear (Cliente cliente);

    Cliente actualizar (Integer id, Cliente cliente);

    public void eliminar (Integer id);
}


