package com.gubee.teste.entity.dto;

import javax.validation.constraints.NotNull;

public class TargetMarketDTO {
        
    private Integer id;

    @NotNull(message = "Nome do mercado alvo não pode ser nulo")
    private String name;

    @NotNull(message = "Produto precisa estar ativo ou não")
    private Boolean active;

    public TargetMarketDTO() {

    }

    public TargetMarketDTO(String name, Boolean active) {
        super();
        this.name = name;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
