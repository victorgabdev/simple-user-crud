package com.victorgabdev.usercrud.entities;

public enum UserStatus {

    INACTIVE(0, "Inativo"),
    ACTIVE(1, "Ativo");

    private int code;
    private String description;

    UserStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static String getDescriptionByCode(int code) {
        for(UserStatus status : UserStatus.values()) {
            if(status.getCode() == code) return status.getDescription();
        }
        throw new IllegalArgumentException("Código inválido: " + code);
    }

    public static int getCodeByDescription(String description) {
        for(UserStatus status : UserStatus.values()) {
            if(status.getDescription().equalsIgnoreCase(description))
                return status.getCode();
        }
        throw new IllegalArgumentException("Descrição inválida: " + description);
    }

}
