package com.example.data_warehouse.dto;



public class KpiGlobalDto {
    public long clientesConCompra;
    public double totalGanancias;
    public long totalVentas;
    public long productosDiferentes;

    public KpiGlobalDto(long clientesConCompra, double totalGanancias, long totalVentas, long productosDiferentes) {
        this.clientesConCompra = clientesConCompra;
        this.totalGanancias = totalGanancias;
        this.totalVentas = totalVentas;
        this.productosDiferentes = productosDiferentes;
    }

    public double getTotalVentas() { return totalVentas; }
    public long getTotalTransacciones() { return totalVentas; }
    public long getClientesUnicos() { return clientesConCompra; }
    public double getTotalProdcutos() { return productosDiferentes; }
}


