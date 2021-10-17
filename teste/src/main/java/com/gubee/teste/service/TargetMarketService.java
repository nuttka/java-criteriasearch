package com.gubee.teste.service;

import com.gubee.teste.entity.Product;
import com.gubee.teste.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gubee.teste.repository.TargetMarketRepository;
import com.gubee.teste.entity.TargetMarket;

import java.util.List;
import java.util.Optional;


@Service
public class TargetMarketService {
    
    @Autowired
    private TargetMarketRepository repository;

    public List<TargetMarket> findAll() {
        return repository.findAll();
    }

    public TargetMarket findById(Integer id) {
        Optional<TargetMarket> product = repository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Mercado alvo não encontrado. Id: " + id));
    }

}
