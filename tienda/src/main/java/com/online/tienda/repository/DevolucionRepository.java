package com.online.tienda.repository;

import com.online.tienda.model.Devolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
    Optional<Devolucion> findByPedidoProducto_Pedido_IdAndPedidoProducto_Producto_Id
            (Integer idPedido, Integer idProducto);
}
