package com.gubee.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gubee.teste.repository.TechnologyRepository;
import com.gubee.teste.entity.Technology;

import java.util.List;


@Service
public class TechnologyService {
    
    @Autowired
    private TechnologyRepository repository;

    public List<Technology> findAll() {
        return repository.findAll();
    }

}
