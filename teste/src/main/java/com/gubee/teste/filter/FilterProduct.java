package com.gubee.teste.filter;

import java.util.List;

import com.gubee.teste.entity.TargetMarket;
import com.gubee.teste.entity.Technology;



public class FilterProduct {
    private List<TargetMarket> targetMarkets;
    
    private List<Technology> technologies;

    FilterProduct() {
    }

    FilterProduct(List<TargetMarket> targetMarkets, List<Technology> technologies) {
        this.targetMarkets = targetMarkets;
        this.technologies = technologies;
    }

    public List<TargetMarket> getTargetMarkets() {
        return targetMarkets;
    }

    public void setTargetMarkets(List<TargetMarket> targetMarkets) {
        this.targetMarkets = targetMarkets;
    }

    public List<Technology> getTechnology() {
        return technologies;
    }

    public void setTechnology(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
