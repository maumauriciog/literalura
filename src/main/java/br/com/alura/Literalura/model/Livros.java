package br.com.alura.Literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String nome;

}
