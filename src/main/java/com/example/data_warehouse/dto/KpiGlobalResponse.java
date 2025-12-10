package com.example.data_warehouse.dto;

import java.math.BigDecimal;

public record KpiGlobalResponse(
        long clientesConCompras,
        BigDecimal totalGanancias,
        long totalVentas,
        long productosDiferentes
) {}
