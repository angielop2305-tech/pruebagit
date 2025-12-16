package com.online.tienda.model;


import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "devolucion")
public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate fecha;

    @Column(length = 50)
    private String estadoProducto;

    @ManyToOne
    @JoinColumn(name = "id_pedido_producto")
    private PedidoProducto pedidoProducto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public PedidoProducto getPedidoProducto() {
        return pedidoProducto;
    }

    public void setPedidoProducto(PedidoProducto pedidoProducto) {
        this.pedidoProducto = pedidoProducto;
    }
}

