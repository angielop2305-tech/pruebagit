package com.online.tienda.controller;

import com.online.tienda.model.Producto;
import com.online.tienda.service.IProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    // ✔ Obtener todos los productos
    @GetMapping("/consultar-todos")
    public List<Producto> buscarTodos() {
        return productoService.buscarTodos();
    }

    // ✔ Consultar un producto por ID
    @GetMapping("/{id}")
    public Producto buscarId(@PathVariable Integer id) {
        return productoService.buscarId(id);
    }

    // ✔ Crear un producto
    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto producto) {
        return productoService.crear(producto);
    }

    // ✔ Actualizar un producto
    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.actualizar(id, producto);
    }

    // ✔ Eliminar un producto
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        productoService.eliminar(id);
    }
}
