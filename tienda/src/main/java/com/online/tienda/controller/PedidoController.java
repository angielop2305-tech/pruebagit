package com.online.tienda.controller;


import com.online.tienda.model.Pedido;
import com.online.tienda.model.Producto;
import com.online.tienda.service.IPedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/pedidos")
public class PedidoController {

    private final IPedidoService pedidoService;

    public PedidoController(IPedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // ✔ Obtener todos los Pedidos
    @GetMapping("/consultar-todos")
    public List<Pedido> buscarTodos() {
        return pedidoService.buscarTodos();
    }

    // ✔ Consultar un Pedido por ID
    @GetMapping("/{id}")
    public Pedido buscarId(@PathVariable Integer id) {
        return pedidoService.buscarId(id);
    }

    // ✔ Crear un Pedido
    @PostMapping("/crear")
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoService.crear(pedido);
    }

    // ✔ Actualizar un Pedido
    @PutMapping("/{id}")
    public Pedido actualizar(@PathVariable Integer id, @RequestBody Pedido pedido) {
        return pedidoService.actualizar(id, pedido);
    }


    // ✔ Eliminar un Pedido
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pedidoService.eliminar(id);
    }
}
