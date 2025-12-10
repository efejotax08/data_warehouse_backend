package com.example.data_warehouse.dto;



import java.math.BigDecimal;

public class GlobalKpiResponse {

    private long uniqueCustomers;
    private long totalSales;
    private BigDecimal totalRevenue;
    private long distinctProducts;

    public GlobalKpiResponse(long uniqueCustomers, long totalSales, BigDecimal totalRevenue, long distinctProducts) {
        this.uniqueCustomers = uniqueCustomers;
        this.totalSales = totalSales;
        this.totalRevenue = totalRevenue;
        this.distinctProducts = distinctProducts;
    }

    public long getUniqueCustomers() {
        return uniqueCustomers;
    }

    public long getTotalSales() {
        return totalSales;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public long getDistinctProducts() {
        return distinctProducts;
    }
}
