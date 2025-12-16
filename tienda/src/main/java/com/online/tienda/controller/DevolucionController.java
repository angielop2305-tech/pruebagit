package com.online.tienda.controller;


import com.online.tienda.model.Devolucion;
import com.online.tienda.model.PedidoProducto;
import com.online.tienda.service.IDevolucionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/devoluciones")
public class DevolucionController {

    private final IDevolucionService devolucionService;

    public DevolucionController(IDevolucionService devolucionService) {
        this.devolucionService = devolucionService;
    }

    // ✔ Obtener todas las devoluciones
    @GetMapping("/consultar-todos")
    public List<Devolucion> buscarTodos() {
        return devolucionService.buscarTodos();
    }

    // ✔ Consultar una devolucion por ID
    @GetMapping("/{id}")
    public Devolucion buscarId(@PathVariable Integer id) {
        return devolucionService.buscarId(id);
    }

    //✔ crear una devolucion
    @PostMapping("/devolver-producto")
    public Devolucion devolverProducto(@RequestParam Integer idPedido,
                                       @RequestParam Integer idProducto,
                                       @RequestParam Integer cantidad,
                                       @RequestParam String estadoProducto)
    {
        PedidoProducto pedidoProducto = devolucionService
                .buscarPedidoProductoPorPedidoYProducto(idPedido, idProducto);

        if (pedidoProducto == null) {
            throw new RuntimeException("No existe ese producto en el pedido");
        }

        Devolucion devolucion = new Devolucion();
        devolucion.setPedidoProducto(pedidoProducto);
        devolucion.setEstadoProducto(estadoProducto);
        devolucion.setFecha(LocalDate.now());

        return devolucionService.crear(devolucion);
    }


    // ✔ Actualizar una devolucion
    @PutMapping("/{id}")
    public Devolucion actualizar(@PathVariable Integer id, @RequestBody Devolucion devolucion) {
        return devolucionService.actualizar(id, devolucion);
    }

    // ✔ Eliminar un Pedido
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        devolucionService.eliminar(id);
    }

    // ✔ Buscar devolucion por id producto, id pedido
    @GetMapping("/buscar")
    public Devolucion buscarPorPedidoYProducto(@RequestParam Integer idPedido, @RequestParam Integer idProducto) {

        return devolucionService.buscarPorPedidoYProducto(idPedido, idProducto);
    }

}