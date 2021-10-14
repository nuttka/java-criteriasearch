package com.gubee.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.gubee.teste.service.TargetMarketService;
import com.gubee.teste.entity.TargetMarket;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/targetMarket/")
public class TargetMarketController {
    
    @Autowired
    private TargetMarketService targetMarketService;

    @GetMapping
    public ResponseEntity<List<TargetMarket>> findAll() {
        return ResponseEntity.ok().body(targetMarketService.findAll());
    }
    
}
