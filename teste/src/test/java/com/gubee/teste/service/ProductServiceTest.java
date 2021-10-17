package com.gubee.teste.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.gubee.teste.entity.Product;
import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.exception.BadRequestException;
import com.gubee.teste.exception.ObjectNotFoundException;
import com.gubee.teste.filter.FilterProduct;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    FilterProduct filterProduct;

    @Before
    public void initFilterProduct() {
        Set<String> targetMarkets = new HashSet<>();
        Set<String> technologies = new HashSet<>();

        targetMarkets.add("Digital Onboarding");

        technologies.add("Java 10");
        technologies.add("Kotlin");

        filterProduct = new FilterProduct(targetMarkets, technologies);
    }

    @Test
    public void findByIdTest() {
        assertEquals("Gubee Integrador", productService.findById(1).getName());
        assertEquals("Ferramenta de integração para marketplaces", productService.findById(1).getDescription());
    }

    @Test
    public void findByIdException() {
        try {
            productService.findById(100);
        } catch(ObjectNotFoundException ex) {
            assertEquals("Produto não encontrado. Id: 100", ex.getMessage());
        }
    }

    @Test
    public void findAllTest() {
        List<Product> products = productService.findAll();

        assertEquals("Gubee Integrador", products.get(0).getName());
        assertEquals("Gubee Fretes", products.get(1).getName());
        assertEquals("Gubee Fretes", products.get(2).getName());
        assertEquals("Gubee AntiFraude", products.get(3).getName());
    }

    @Test
    public void searchProductTest() {
        List<Product> products = productService.searchProduct(filterProduct);

        assertEquals("Gubee Integrador", products.get(0).getName());
        assertEquals("Gubee AntiFraude", products.get(1).getName());
    }

    @Test
    public void searchProductException() {
        try {
            FilterProduct filter = null;
            productService.searchProduct(filter);
        } catch(BadRequestException ex) {
            assertEquals("filterProduct não pode ser nulo.", ex.getMessage());
        }
    }
    
}
