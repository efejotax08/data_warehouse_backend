package com.example.data_warehouse.service;


import com.example.data_warehouse.dto.ClimaPorDiaDto;
import com.example.data_warehouse.dto.VentaPorDiaDto;
import com.example.data_warehouse.repository.AnalyticsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoService {

    private final AnalyticsRepository repository;

    public InfoService(AnalyticsRepository repository) {
        this.repository = repository;
    }

    public List<VentaPorDiaDto> obtenerVentasPorDia(String ciudad,
                                                    LocalDate desde,
                                                    LocalDate hasta) {
        return repository.findVentasPorDiaRaw(ciudad, desde, hasta)
                .stream()
                .map(row -> new VentaPorDiaDto(
                        (LocalDate) row[0],
                        (BigDecimal) row[1],
                        ((Number) row[2]).longValue()
                ))
                .collect(Collectors.toList());
    }

    public List<ClimaPorDiaDto> obtenerClimaPorDia(String ciudad,
                                                   LocalDate desde,
                                                   LocalDate hasta) {
        return repository.findClimaPorDiaRaw(ciudad, desde, hasta)
                .stream()
                .map(row -> new ClimaPorDiaDto(
                        (LocalDate) row[0],
                        (String) row[1],
                        (BigDecimal) row[2],
                        (BigDecimal) row[3],
                        (BigDecimal) row[4]
                ))
                .collect(Collectors.toList());
    }
}
