package com.online.tienda.controller;


import com.online.tienda.model.Cliente;
import com.online.tienda.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {

        private final IClienteService clienteService;

        public ClienteController(IClienteService clienteService) {
            this.clienteService = clienteService;
        }

        // ✔ Obtener todos los clientes
        @GetMapping("/consultar-todos")
        public List<Cliente> buscarTodos() {
            return clienteService.buscarTodos();
        }

        // ✔ Consultar un cliente por ID
        @GetMapping("/{id}")
        public Cliente buscarId(@PathVariable Integer id) {
            return clienteService.buscarId(id);
        }

        // ✔ Crear un cliente
        @PostMapping ("/crear")
        public Cliente crear(@RequestBody Cliente cliente) {
            return clienteService.crear(cliente);
        }

        // ✔ Actualizar un cliente
        @PutMapping("/{id}")
        public Cliente actualizar(@PathVariable Integer id, @RequestBody Cliente cliente) {
            return clienteService.actualizar(id, cliente);
        }

        // ✔ Eliminar un cliente
        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Integer id) {
            clienteService.eliminar(id);
        }
    }

