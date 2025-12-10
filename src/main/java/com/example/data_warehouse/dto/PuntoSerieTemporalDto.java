package com.example.data_warehouse.dto;

import java.time.LocalDate;

public class PuntoSerieTemporalDto {
    private LocalDate fecha;
    private double totalVentas;

    public PuntoSerieTemporalDto(LocalDate fecha, double totalVentas) {
        this.fecha = fecha;
        this.totalVentas = totalVentas;
    }

    public LocalDate getFecha() { return fecha; }
    public double getTotalVentas() { return totalVentas; }
}
