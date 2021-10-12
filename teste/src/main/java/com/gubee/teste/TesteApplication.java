package com.gubee.teste;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gubee.teste.entity.Product;
import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.entity.Technology;
import com.gubee.teste.repository.ProductRepository;
import com.gubee.teste.repository.TargetMarketRepository;
import com.gubee.teste.repository.TechnologyRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}

    @Bean
    public CommandLineRunner mappingDemo(ProductRepository productRepository,
                                         TargetMarketRepository targetMarketRepository,
										 TechnologyRepository technologyRepository) {
        return args -> {

			
			TargetMarket targetMarket1 = new TargetMarket("Ecommerce", true);
			TargetMarket targetMarket2 = new TargetMarket("ERP", true);
			TargetMarket targetMarket3 = new TargetMarket("Lojista que não desejam possuir ecommerce", true);
			TargetMarket targetMarket4 = new TargetMarket("Loja fisica", true);
			TargetMarket targetMarket5 = new TargetMarket("Telecom", true);
			TargetMarket targetMarket6 = new TargetMarket("Venda direta", true);
			TargetMarket targetMarket7 = new TargetMarket("Mobile First", true);
			TargetMarket targetMarket8 = new TargetMarket("Digital Onboarding", true);
			
			targetMarketRepository.saveAll(Arrays.asList(targetMarket1, targetMarket2, targetMarket3, targetMarket4, targetMarket5, targetMarket6, targetMarket7, targetMarket8));


			Technology technology1 = new Technology("Java 10", true);
			Technology technology2 = new Technology("Kotlin", true);
			Technology technology3 = new Technology("Kafka", true);
			Technology technology4 = new Technology("Event Stream", true);
			Technology technology5 = new Technology("Redis", true);
			Technology technology6 = new Technology("MongoDB", true);
			Technology technology7 = new Technology("NodeJS", true);
			Technology technology8 = new Technology("Big Data Analytics", true);
			Technology technology9 = new Technology("Hadoop", true);
			Technology technology10 = new Technology("Pig", true);
			Technology technology11 = new Technology("Cassandra", true);

			technologyRepository.saveAll(Arrays.asList(technology1, technology2, technology3, technology4, technology5, technology6, technology7, technology8, technology9, technology10, technology11));


            Product product1 = new Product("Gubee Integrador", "Ferramenta de integração para marketplaces", new HashSet<TargetMarket>(),
										new HashSet<Technology>(), true);
			productRepository.save(product1);

			product1.setTargetMarkets(Stream.of(targetMarket1, targetMarket2, targetMarket3).collect(Collectors.toSet()));
			product1.setTechnologies(Stream.of(technology1, technology2, technology3, technology4, technology5, technology6).collect(Collectors.toSet()));
			productRepository.save(product1);
			
            Product product2 = new Product("Gubee Fretes", "Ferramenta para gestão e calculo de fretes", new HashSet<TargetMarket>(),
										new HashSet<Technology>(), true);
			productRepository.save(product2);

			product2.setTargetMarkets(Stream.of(targetMarket1, targetMarket2, targetMarket4).collect(Collectors.toSet()));
			product2.setTechnologies(Stream.of(technology7, technology6).collect(Collectors.toSet()));
			productRepository.save(product2);
			
            Product product3 = new Product("Gubee Fretes", "Ferramenta para gestão e calculo de fretes",new HashSet<TargetMarket>(),
										new HashSet<Technology>(), true);
			productRepository.save(product3);

			product3.setTargetMarkets(Stream.of(targetMarket1, targetMarket2, targetMarket4).collect(Collectors.toSet()));
			product3.setTechnologies(Stream.of(technology7, technology6).collect(Collectors.toSet()));
			productRepository.save(product3);
			
            Product product4 = new Product("Gubee AntiFraude", "Ferramenta especialistas em detecção e prevenção à fraude", new HashSet<TargetMarket>(),
										new HashSet<Technology>(), true);
			productRepository.save(product4);

			product4.setTargetMarkets(Stream.of(targetMarket1, targetMarket5, targetMarket6, targetMarket7, targetMarket8).collect(Collectors.toSet()));
			product4.setTechnologies(Stream.of(technology8, technology9, technology3, technology10, technology11).collect(Collectors.toSet()));
			productRepository.save(product4);

        };
    }

}
