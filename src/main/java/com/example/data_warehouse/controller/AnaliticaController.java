package com.example.data_warehouse.controller;

import com.example.data_warehouse.dto.KpiResumenDto;
import com.example.data_warehouse.dto.PuntoSerieTemporalDto;
import com.example.data_warehouse.service.AnaliticaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnaliticaController {

    private final AnaliticaService analiticaService;

    public AnaliticaController(AnaliticaService analiticaService) {
        this.analiticaService = analiticaService;
    }

    // 1) Endpoint de KPIs agregados
    @GetMapping("/kpis")
    public KpiResumenDto obtenerKpis(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        return analiticaService.obtenerKpis(desde, hasta);
    }

    // 2) Endpoint de serie temporal de ventas diarias
    @GetMapping("/series/ventas-diarias")
    public List<PuntoSerieTemporalDto> obtenerSerieVentasDiarias(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {

        return analiticaService.obtenerSerieVentasDiarias(desde, hasta);
    }
}
