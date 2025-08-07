package com.victorgabdev.usercrud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tab_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "tu_nome")
    private String name;

    @Column(name = "tu_idade")
    private Integer age;

    @Column(name = "tu_cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "tu_email", nullable = false, unique = true)
    private String email;

    @Column(name = "tu_senha", nullable = false, unique = true)
    private String password;

    @Column(name = "tu_status", nullable = false)
    private UserStatus status;

    public User() {
    }

    public User(String name, Integer age, String cpf, String email, String password) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.status = UserStatus.ACTIVE;
    }

    public User(String name, Integer age, String cpf, String email, String password, UserStatus status) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.status = status;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
