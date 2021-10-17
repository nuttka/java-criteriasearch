package com.gubee.teste.service;


import com.gubee.teste.entity.Product;
import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.exception.ObjectNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class TargetMarketServiceTest {

    @Autowired
    TargetMarketService targetMarketService;

    @Test
    public void findByIdTest() {
        assertEquals("Ecommerce", targetMarketService.findById(1).getName());
        assertEquals("ERP", targetMarketService.findById(2).getName());
    }

    @Test
    public void findByIdException() {
        try {
            targetMarketService.findById(100);
        } catch(ObjectNotFoundException ex) {
            assertEquals("Mercado alvo não encontrado. Id: 100", ex.getMessage());
        }
    }

    @Test
    public void findAllTest() {
        List<TargetMarket> targetMarkets = targetMarketService.findAll();

        assertEquals("Ecommerce", targetMarkets.get(0).getName());
        assertEquals("ERP", targetMarkets.get(1).getName());
        assertEquals("Lojista que não desejam possuir ecommerce", targetMarkets.get(2).getName());
        assertEquals("Loja fisica", targetMarkets.get(3).getName());
        assertEquals("Telecom", targetMarkets.get(4).getName());
        assertEquals("Venda direta", targetMarkets.get(5).getName());
        assertEquals("Mobile First", targetMarkets.get(6).getName());
        assertEquals("Digital Onboarding", targetMarkets.get(7).getName());
    }
}
