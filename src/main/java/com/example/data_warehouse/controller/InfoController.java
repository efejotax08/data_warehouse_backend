package com.example.data_warehouse.controller;


import com.example.data_warehouse.dto.ClimaPorDiaDto;
import com.example.data_warehouse.dto.VentaPorDiaDto;
import com.example.data_warehouse.service.InfoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class InfoController {

    private final InfoService service;

    public InfoController(InfoService service) {
        this.service = service;
    }

    // 1) Serie temporal de ventas por día
    // GET /api/analytics/series/ventas?desde=2025-01-01&hasta=2025-03-31&ciudad=Quito
    @CrossOrigin(origins = "*")
    @GetMapping("/series/ventas")
    public List<VentaPorDiaDto> getVentasPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
            @RequestParam(required = false) String ciudad
    ) {
        return service.obtenerVentasPorDia(ciudad, desde, hasta);
    }

    // 2) Serie temporal de clima por día
    // GET /api/analytics/series/clima?desde=2025-01-01&hasta=2025-03-31&ciudad=Quito
    @CrossOrigin(origins = "*")
    @GetMapping("/series/clima")
    public List<ClimaPorDiaDto> getClimaPorDia(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
            @RequestParam(required = false) String ciudad
    ) {
        return service.obtenerClimaPorDia(ciudad, desde, hasta);
    }
}

