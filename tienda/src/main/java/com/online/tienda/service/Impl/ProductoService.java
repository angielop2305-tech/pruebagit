package com.online.tienda.service.Impl;

import com.online.tienda.model.Producto;
import com.online.tienda.repository.ProductoRepository;
import com.online.tienda.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository productoRepo;

    public ProductoService(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public List<Producto> buscarTodos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto buscarId(Integer id) {
        return productoRepo.findById(id).get();
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {

        Producto existente= productoRepo.findById(id).orElseThrow(()
                -> new RuntimeException( " No existe el producto" + id));

        existente.setNombre(producto.getNombre());
        existente.setStock(producto.getStock());
        existente.setPrecio(producto.getPrecio());
        existente.setEstado(producto.getEstado());

        return productoRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        productoRepo.deleteById(id);

    }


}


