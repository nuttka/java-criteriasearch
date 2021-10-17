package com.gubee.teste.service;

import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.entity.Technology;
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
public class TechnologyServiceTest {

    @Autowired
    TechnologyService technologyService;

    @Test
    public void findByIdTest() {
        assertEquals("Java 10", technologyService.findById(1).getName());
        assertEquals("Kotlin", technologyService.findById(2).getName());
    }

    @Test
    public void findByIdException() {
        try {
            technologyService.findById(100);
        } catch(ObjectNotFoundException ex) {
            assertEquals("Tecnologia não encontrada. Id: 100", ex.getMessage());
        }
    }

    @Test
    public void findAllTest() {
        List<Technology> technologies = technologyService.findAll();

        assertEquals("Java 10", technologies.get(0).getName());
        assertEquals("Kotlin", technologies.get(1).getName());
        assertEquals("Kafka", technologies.get(2).getName());
        assertEquals("Event Stream", technologies.get(3).getName());
        assertEquals("Redis", technologies.get(4).getName());
        assertEquals("MongoDB", technologies.get(5).getName());
        assertEquals("NodeJS", technologies.get(6).getName());
        assertEquals("Big Data Analytics", technologies.get(7).getName());
        assertEquals("Hadoop", technologies.get(8).getName());
        assertEquals("Pig", technologies.get(9).getName());
        assertEquals("Cassandra", technologies.get(10).getName());
    }
}
