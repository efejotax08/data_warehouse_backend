package com.example.data_warehouse.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "fct_ventas", schema = "dw")
public class FctVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_venta")
    private Long id;

    // No hace falta mapear todas las columnas para los queries nativos
}
