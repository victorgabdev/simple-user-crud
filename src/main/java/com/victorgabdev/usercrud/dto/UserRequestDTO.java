package com.victorgabdev.usercrud.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {


    @NotNull
    private String name;

    private Integer age;

    @NotNull
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @NotNull
    @Size(min = 6)
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, Integer age, String cpf, String email, String password) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
