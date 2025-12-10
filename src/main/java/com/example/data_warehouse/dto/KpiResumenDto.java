package com.example.data_warehouse.dto;

public class KpiResumenDto {
    private double totalVentas;
    private long totalTransacciones;
    private long clientesUnicos;
    private double ticketPromedio;

    public KpiResumenDto(double totalVentas, long totalTransacciones,
                         long clientesUnicos, double ticketPromedio) {
        this.totalVentas = totalVentas;
        this.totalTransacciones = totalTransacciones;
        this.clientesUnicos = clientesUnicos;
        this.ticketPromedio = ticketPromedio;
    }

    public double getTotalVentas() { return totalVentas; }
    public long getTotalTransacciones() { return totalTransacciones; }
    public long getClientesUnicos() { return clientesUnicos; }
    public double getTicketPromedio() { return ticketPromedio; }
}
