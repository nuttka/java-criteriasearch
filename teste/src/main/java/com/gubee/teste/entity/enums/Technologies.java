package com.gubee.teste.entity.enums;

public enum Technologies {
    DOMINGO(1, "DOMINGO"),
    SEGUNDA(2, "SEGUNDA"),
    TERCA(3, "TERCA"),
    QUARTA(4, "QUARTA"),
    QUINTA(5, "QUINTA"),
    SEXTA(6, "SEXTA"),
    SABADO(7, "SABADO");

    private int code;
    private String name;

    private Technologies(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Technologies toEnum(Integer code) {
        if(code == null) {
            return null;
        }

        for(Technologies x: Technologies.values()) {
            if(code.equals(x.getCode())) {
                return x;
            }
        }

        return null;
    }
}
