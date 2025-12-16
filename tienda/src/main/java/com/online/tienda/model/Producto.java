package com.online.tienda.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String nombre;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal precio;

    @Column(length = 20, nullable = true)
    private String estado;

    @OneToMany(mappedBy = "producto")
    private List<PedidoProducto> pedidos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PedidoProducto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoProducto> pedidos) {
        this.pedidos = pedidos;
    }
}

