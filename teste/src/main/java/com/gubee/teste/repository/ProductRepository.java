package com.gubee.teste.repository;

import com.gubee.teste.entity.Product;
import com.gubee.teste.repository.criteria.ProductRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, ProductRepositoryCustom {
    
}
