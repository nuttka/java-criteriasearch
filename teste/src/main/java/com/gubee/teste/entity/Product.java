package com.gubee.teste.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "targetMarkets")
    private ArrayList<TargetMarket> targetMarkets;
    
    @Column(name = "technologies")
    private ArrayList<Technology> technologies;

    public Product() {

    }

    public Product(String name, String description, ArrayList<TargetMarket> targetMarkets, ArrayList<Technology> technologies) {
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
