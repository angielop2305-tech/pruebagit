package com.online.tienda.service.Impl;

import com.online.tienda.model.Cliente;
import com.online.tienda.repository.ClienteRepository;
import com.online.tienda.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {


    private final ClienteRepository clienteRepo;

    public ClienteService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente buscarId(Integer id) {
        return clienteRepo.findById(id).get();
    }

    @Override
    public Cliente crear(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente actualizar(Integer id, Cliente cliente) {
        Cliente existente = clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException(" NO existe el cliente con el id: " + id));

        existente.setNombre(cliente.getNombre());
        existente.setTelefono(cliente.getTelefono());
        existente.setDireccion(cliente.getDireccion());
        existente.setCorreo(cliente.getCorreo());

        return clienteRepo.save(existente);
    }


    @Override
    public void eliminar(Integer id) {
        clienteRepo.deleteById(id);

    }
}

