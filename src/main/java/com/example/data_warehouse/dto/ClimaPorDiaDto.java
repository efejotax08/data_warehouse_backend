package com.example.data_warehouse.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public class ClimaPorDiaDto {

    private LocalDate fecha;
    private String ciudad;
    private BigDecimal temperatura;
    private BigDecimal humedad;
    private BigDecimal precipitacion;

    public ClimaPorDiaDto(LocalDate fecha, String ciudad,
                          BigDecimal temperatura, BigDecimal humedad,
                          BigDecimal precipitacion) {
        this.fecha = fecha;
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.precipitacion = precipitacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getCiudad() {
        return ciudad;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public BigDecimal getHumedad() {
        return humedad;
    }

    public BigDecimal getPrecipitacion() {
        return precipitacion;
    }
}
