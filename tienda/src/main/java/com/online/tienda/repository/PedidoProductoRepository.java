package com.online.tienda.repository;

import com.online.tienda.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Integer> {

    Optional<PedidoProducto> findByPedido_IdAndProducto_Id(Integer idPedido, Integer idProducto);
}
