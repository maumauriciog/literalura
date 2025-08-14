package br.com.alura.Literalura.entidades;

import br.com.alura.Literalura.DTO.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;

    @OneToMany(mappedBy = "autores", fetch = FetchType.EAGER)
    private List<Livro> livros;

    public Autor() {
    }

    public Autor(AutorDTO autorDTO) {
        this.nome = autorDTO.nome();
        this.anoNascimento = autorDTO.anoDeNascimento();
        this.anoFalecimento = autorDTO.anoFalecimento();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

//    @Override
//    public String toString() {
//        return "\n----- Author -----\n-> Nome = '" + nome + '\'' +
//                "-> Ano de Nascimento = " + anoNascimento +
//                "-> Ano de Falecimento =" + anoFalecimento +
//                "-> livros=" + livros;
//    }
}