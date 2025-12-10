package com.example.data_warehouse.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class VentaPorDiaDto {

    private LocalDate fecha;
    private BigDecimal totalVentas;
    private Long unidades;

    public VentaPorDiaDto(LocalDate fecha, BigDecimal totalVentas, Long unidades) {
        this.fecha = fecha;
        this.totalVentas = totalVentas;
        this.unidades = unidades;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public BigDecimal getTotalVentas() {
        return totalVentas;
    }

    public Long getUnidades() {
        return unidades;
    }
}
