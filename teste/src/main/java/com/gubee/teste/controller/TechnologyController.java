package com.gubee.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.gubee.teste.service.TechnologyService;
import com.gubee.teste.entity.Technology;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/technology/")
public class TechnologyController {
    
    @Autowired
    private TechnologyService technologyService;

    @GetMapping
    public ResponseEntity<List<Technology>> findAll() {
        return ResponseEntity.ok().body(technologyService.findAll());
    }

}
