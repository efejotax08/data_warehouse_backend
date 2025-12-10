package com.example.data_warehouse.repository;


import com.example.data_warehouse.dto.ClimaPorDiaDto;
import com.example.data_warehouse.dto.VentaPorDiaDto;
import com.example.data_warehouse.entity.FctVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AnalyticsRepository extends JpaRepository<FctVenta, Long> {

    // Serie temporal de ventas por día, opcionalmente filtrada por ciudad (clima)
    @Query(
            value = """
                SELECT 
                    df.fecha           AS fecha,
                    SUM(fv.total)      AS total_ventas,
                    SUM(fv.cantidad)   AS unidades
                FROM dw.fct_ventas fv
                JOIN dw.dim_fecha df   ON fv.sk_fecha = df.sk_fecha
                JOIN dw.dim_clima dc   ON fv.sk_clima = dc.sk_clima
                WHERE (:ciudad IS NULL OR dc.ciudad = :ciudad)
                  AND df.fecha BETWEEN :desde AND :hasta
                GROUP BY df.fecha
                ORDER BY df.fecha
                """,
            nativeQuery = true)
    List<Object[]> findVentasPorDiaRaw(@Param("ciudad") String ciudad,
                                       @Param("desde") LocalDate desde,
                                       @Param("hasta") LocalDate hasta);

    // Serie temporal del clima por día
    @Query(
            value = """
                SELECT 
                    df.fecha         AS fecha,
                    dc.ciudad        AS ciudad,
                    dc.temperatura   AS temperatura,
                    dc.humedad       AS humedad,
                    dc.precipitacion AS precipitacion
                FROM dw.dim_clima dc
                JOIN dw.dim_fecha df ON dc.sk_fecha = df.sk_fecha
                WHERE (:ciudad IS NULL OR dc.ciudad = :ciudad)
                  AND df.fecha BETWEEN :desde AND :hasta
                ORDER BY df.fecha
                """,
            nativeQuery = true)
    List<Object[]> findClimaPorDiaRaw(@Param("ciudad") String ciudad,
                                      @Param("desde") LocalDate desde,
                                      @Param("hasta") LocalDate hasta);
}
