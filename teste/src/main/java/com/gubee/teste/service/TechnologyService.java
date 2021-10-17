package com.gubee.teste.service;

import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gubee.teste.repository.TechnologyRepository;
import com.gubee.teste.entity.Technology;

import java.util.List;
import java.util.Optional;


@Service
public class TechnologyService {
    
    @Autowired
    private TechnologyRepository repository;

    public List<Technology> findAll() {
        return repository.findAll();
    }

    public Technology findById(Integer id) {
        Optional<Technology> product = repository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Tecnologia não encontrada. Id: " + id));
    }
}
