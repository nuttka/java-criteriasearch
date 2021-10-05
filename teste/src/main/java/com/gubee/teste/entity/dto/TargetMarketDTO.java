package com.gubee.teste.entity.dto;

import javax.validation.constraints.NotNull;

public class TargetMarketDTO {
        
    private Integer id;

    @NotNull(message = "Nome do mercado alvo não pode ser nulo")
    private String name;

    public TargetMarketDTO() {

    }

    public TargetMarketDTO(String name) {
        super();
        this.name = name;
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

}
