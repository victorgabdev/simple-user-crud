package com.victorgabdev.usercrud.dto;

public class UserResponseDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String cpf;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Integer id, String name, Integer age, String cpf, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getId() {
        return id;
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

}
