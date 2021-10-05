package com.gubee.teste.entity.dto;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;

import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.entity.Technology;

public class ProductDTO {
    
    private Integer id;
    @NotNull(message = "Nome do produto não pode ser nulo")
    private String name;

    @NotNull(message = "Descrição do produto não pode ser nulo")
    private String description;

    @NotNull(message = "Mercado alvo do produto não pode ser nulo")
    private ArrayList<TargetMarket> targetMarkets;
    
    @NotNull(message = "Tecnologia do produto não pode ser nulo")
    private ArrayList<Technology> technologies;

    public ProductDTO() {

    }

    public ProductDTO(String name, String description, ArrayList<TargetMarket> targetMarkets, ArrayList<Technology> technologies) {
        super();
        this.name = name;
        this.description = description;
        this.targetMarkets = targetMarkets;
        this.technologies = technologies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<TargetMarket> getTargetMarkets() {
        return targetMarkets;
    }

    
    public void setTargetMarkets(ArrayList<TargetMarket> targetMarkets) {
        this.targetMarkets = targetMarkets;
    }
    
    public ArrayList<Technology> getTechnologies() {
        return technologies;
    }
    
    public void setTechnologies(ArrayList<Technology> technologies) {
        this.technologies = technologies;
    }
}



