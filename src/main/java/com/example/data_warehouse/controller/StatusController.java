package com.example.data_warehouse.controller;  // <-- ajusta al nombre REAL de tu paquete

import com.example.data_warehouse.dto.KpiGlobalResponse;
import com.example.data_warehouse.repository.FctVentasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class StatusController {

    private final FctVentasRepository fctVentasRepository;
    public StatusController(FctVentasRepository fctVentasRepository) {
        this.fctVentasRepository = fctVentasRepository;
    }

    @GetMapping("/kpis-globales")
    public KpiGlobalResponse getKpisGlobales() {
        long clientes = fctVentasRepository.countClientesConCompras();
        var ganancias = fctVentasRepository.totalGanancias();
        long ventas = fctVentasRepository.totalVentas();
        long productos = fctVentasRepository.totalProductosDiferentes();

        return new KpiGlobalResponse(clientes, ganancias, ventas, productos);
    }




    @GetMapping("/api/status")
    public String status() {
        return "DW Backend OK";
    }

    @GetMapping("/")
    public String mostrarPagina() {
        return "Hola, esta es la página de inicio.";
    }


}
