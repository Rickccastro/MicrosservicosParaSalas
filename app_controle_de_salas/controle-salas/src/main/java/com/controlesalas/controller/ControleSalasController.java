package com.controlesalas.controller;



import com.controlesalas.dto.SalaDto;
import com.controlesalas.entity.Sala;
import com.controlesalas.service.SalaService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class ControleSalasController {

    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    SalaService salaService;


    @PostMapping("/addSala")
    public String addSala(@RequestBody SalaDto salaDto) {

        return salaService.addSala(salaDto);
    }
    @PatchMapping ("/maintenceSala")
    public String maintenceSala(@RequestBody SalaDto salaDto) {

        return salaService.maintenceSala(salaDto);
    }

    @GetMapping("/availableSalas")
    public String availableSalas() {

        return salaService.getAvailableSala();
    }
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/health")
    public String healthy() {
        return "Estou vivo e bem! Sou a app "+appName+" - " + LocalDateTime.now();
    }
}
