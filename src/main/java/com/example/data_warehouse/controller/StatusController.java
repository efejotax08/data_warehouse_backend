package com.example.data_warehouse.controller;  // <-- ajusta al nombre REAL de tu paquete

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/api/status")
    public String status() {
        return "DW Backend OK";
    }
}
