package br.com.alura.Literalura.model;

import br.com.alura.Literalura.DTO.AutorDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Livros> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(AutorDTO dadosAutor) {
        this.nome = String.valueOf(dadosAutor.nome());
        this.anoNascimento = Integer.valueOf(dadosAutor.anoNascimento());
        this.anoFalecimento = Integer.valueOf(dadosAutor.anoFalecimento());
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento +
                ", livros=" + livros +
                '}';
    }
}
