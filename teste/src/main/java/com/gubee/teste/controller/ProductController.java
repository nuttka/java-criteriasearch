package com.gubee.teste.controller;

import java.util.List;

import com.gubee.teste.entity.Product;
import com.gubee.teste.filter.FilterProduct;
import com.gubee.teste.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @PostMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestBody FilterProduct FilterProduct){
        return ResponseEntity.ok().body(productService.searchProduct(FilterProduct));
    }
    
}
