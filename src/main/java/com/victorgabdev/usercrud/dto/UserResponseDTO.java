package com.victorgabdev.usercrud.dto;

import com.victorgabdev.usercrud.entities.UserStatus;

public class UserResponseDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String cpf;
    private String email;
    private UserStatus status;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String name, Integer age, String cpf, String email, UserStatus status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public UserStatus getStatus() {
        return status;
    }

}
