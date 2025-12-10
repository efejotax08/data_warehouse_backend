package com.example.data_warehouse.repository;

import java.math.BigDecimal;

public interface GlobalKpiProjection {
    Long getUniqueCustomers();
    Long getTotalSales();
    BigDecimal getTotalRevenue();
    Long getDistinctProducts();
}