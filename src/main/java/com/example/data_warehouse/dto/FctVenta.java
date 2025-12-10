package com.example.data_warehouse.dto;


import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "fct_ventas", schema = "dw")
public class FctVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_venta")
    private Long sk_venta;

    @Column(name = "id_venta_natural", nullable = false)
    private Long id_venta_natural;

    @Column(name = "sk_cliente", nullable = false)
    private Long sk_cliente;

    @Column(name = "sk_fecha", nullable = false)
    private Long sk_fecha;


    @Column(name = "producto")
    private String producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private BigDecimal total;

    // Getters y setters (puedes usar Lombok si ya lo tienes)
    // ...
}
