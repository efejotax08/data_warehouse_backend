package com.example.data_warehouse.repository;


import com.example.data_warehouse.dto.FctVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface FctVentasRepository extends JpaRepository<FctVenta, Long> {

    // 1) Conteo de clientes que hayan realizado al menos una compra
    @Query("select count(distinct v.sk_cliente) from FctVenta v")
    long countClientesConCompras();

    // 2) Total de ganancias (suma de total)
    @Query("select coalesce(sum(v.total), 0) from FctVenta v")
    BigDecimal totalGanancias();

    // 3) Total de ventas (cantidad de registros en la tabla de hechos)
    @Query("select count(v) from FctVenta v")
    long totalVentas();

    // 4) Total de productos diferentes
    @Query("select count(distinct v.producto) from FctVenta v")
    long totalProductosDiferentes();
}
