package com.gubee.teste.filter;

import java.util.Set;



public class FilterProduct {
    private Set<String> targetMarkets;
    
    private Set<String> technologies;

    public FilterProduct() {
    }

    public FilterProduct(Set<String> targetMarkets, Set<String> technologies) {
        this.targetMarkets = targetMarkets;
        this.technologies = technologies;
    }

    public Set<String> getTargetMarkets() {
        return targetMarkets;
    }

    public void setTargetMarkets(Set<String> targetMarkets) {
        this.targetMarkets = targetMarkets;
    }

    public Set<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<String> technologies) {
        this.technologies = technologies;
    }
}
