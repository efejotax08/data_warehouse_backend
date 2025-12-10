package com.example.data_warehouse.controller;  // <-- ajusta al nombre REAL de tu paquete

//import com.example.data_warehouse.dto.KpiGlobalResponse;
//import com.example.data_warehouse.repository.FctVentasRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StatusController {


    public StatusController() {


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
