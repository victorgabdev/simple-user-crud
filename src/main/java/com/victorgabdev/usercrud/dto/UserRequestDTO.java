package com.victorgabdev.usercrud.dto;


import com.victorgabdev.usercrud.entities.UserStatus;
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

    private UserStatus status;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name, Integer age, String cpf, String email, String password, UserStatus status) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public UserStatus getStatus() {
        return status;
    }
}
