package com.online.tienda.service.Impl;

import com.online.tienda.model.Devolucion;
import com.online.tienda.model.PedidoProducto;
import com.online.tienda.repository.DevolucionRepository;
import com.online.tienda.repository.PedidoProductoRepository;
import com.online.tienda.repository.PedidoRepository;
import com.online.tienda.service.IDevolucionService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DevolucionService implements IDevolucionService {

    private final DevolucionRepository devolucionRepo;
    private final PedidoProductoRepository pedidoProductoRepo;

    public DevolucionService(DevolucionRepository devolucionRepo, PedidoProductoRepository pedidoProductoRepo) {
        this.devolucionRepo = devolucionRepo;
        this.pedidoProductoRepo = pedidoProductoRepo;
    }


    @Override
    public List<Devolucion> buscarTodos() {
        return devolucionRepo.findAll();
    }

    @Override
    public Devolucion buscarId(Integer id) {
        return devolucionRepo.findById(id).get();
    }

    @Override
    public Devolucion crear(Devolucion devolucion) {
        return devolucionRepo.save(devolucion);
    }

    @Override
    public Devolucion actualizar(Integer id, Devolucion devolucion) {
        Devolucion existente = devolucionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe la devolucion con el id: " + id));

        existente.setFecha(devolucion.getFecha());
        existente.setEstadoProducto(devolucion.getEstadoProducto());
        existente.setPedidoProducto(devolucion.getPedidoProducto());

        return devolucionRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        devolucionRepo.deleteById(id);

    }

    @Override
    public Devolucion buscarPorPedidoYProducto(Integer idPedido, Integer idProducto) {
       return devolucionRepo
                .findByPedidoProducto_Pedido_IdAndPedidoProducto_Producto_Id(idPedido, idProducto)
                .orElse(null);
    }

    @Override
    public PedidoProducto buscarPedidoProductoPorPedidoYProducto(Integer idPedido, Integer idProducto) {
        return pedidoProductoRepo.findByPedido_IdAndProducto_Id(idPedido, idProducto)
                .orElse(null);
    }

}
