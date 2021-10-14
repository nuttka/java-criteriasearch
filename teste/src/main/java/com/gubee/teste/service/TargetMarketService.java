package com.gubee.teste.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gubee.teste.repository.TargetMarketRepository;
import com.gubee.teste.entity.TargetMarket;

import java.util.List;


@Service
public class TargetMarketService {
    
    @Autowired
    private TargetMarketRepository repository;

    public List<TargetMarket> findAll() {
        return repository.findAll();
    }

}
