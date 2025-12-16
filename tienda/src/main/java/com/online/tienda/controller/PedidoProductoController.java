package com.online.tienda.controller;

import com.online.tienda.model.PedidoProducto;
import com.online.tienda.service.IPedidoProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido-producto")
public class PedidoProductoController {

    private final IPedidoProductoService pedidoProductoService;

    public PedidoProductoController(IPedidoProductoService pedidoProductoService) {
        this.pedidoProductoService = pedidoProductoService;
    }

    @GetMapping("/consultar-todos")
    public List<PedidoProducto> buscarTodos() {
        return pedidoProductoService.buscarTodos();
    }

    @GetMapping("/{id}")
    public PedidoProducto buscarId(@PathVariable Integer id) {
        return pedidoProductoService.buscarId(id);
    }

    @PostMapping("/crear")
    public PedidoProducto crear(@RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoService.crear(pedidoProducto);
    }

    @PutMapping("/{id}")
    public PedidoProducto actualizar(@PathVariable Integer id, @RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoService.actualizar(id, pedidoProducto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pedidoProductoService.eliminar(id);
    }
}
