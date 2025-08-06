package com.victorgabdev.usercrud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "tu_nome")
    private String nome;

    @Column(name = "tu_idade")
    private Integer idade;

    @Column(name = "tu_cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "tu_email", nullable = false, unique = true)
    private String email;

}
