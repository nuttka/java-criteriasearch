package com.gubee.teste.entity.dto;

import javax.validation.constraints.NotNull;

public class TechnologyDTO {
    private Integer id;
    
    @NotNull(message = "Nome da tecnologia não pode ser nulo")
    private String name;

    public TechnologyDTO() {

    }

    public TechnologyDTO(Integer id, String name) {
        super();
        this.id = id;
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
