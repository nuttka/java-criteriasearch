package com.gubee.teste.service;

import com.gubee.teste.entity.Product;
import com.gubee.teste.exception.BadRequestException;
import com.gubee.teste.exception.ObjectNotFoundException;
import com.gubee.teste.filter.FilterProduct;
import com.gubee.teste.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    
    public Product findById(Integer id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado. Id: " + id));
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> searchProduct(FilterProduct filterProduct) {
        if(filterProduct == null) {
            throw new BadRequestException("filterProduct não pode ser nulo.");
        }
        return repository.searchByFilter(filterProduct);
    }
    
}
