package br.com.alura.Literalura.entidades;

import br.com.alura.Literalura.DTO.LivroDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;
    private List<String> idioma;
    private Integer nDownloads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro() {
    }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.titulo();
        this.autor = (Autor) livroDTO.autor();
        this.idioma = livroDTO.idioma();
        this.nDownloads = livroDTO.nDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getnDownloads() {
        return nDownloads;
    }

    public void setnDownloads(Integer nDownloads) {
        this.nDownloads = nDownloads;
    }

    public Autor getAutores() {
        return autor;
    }

    public void setAutores(Autor autores) {
        this.autor = autores;
    }

    @Override
    public String toString() {
        return "    -> Título: " + titulo + "\n" +
                "    -> Autor: " + autor + "\n" +
                "    -> Idioma: " + idioma + "\n" +
                "    -> N. Downoads: " + nDownloads + "\n\n          -----\n";
    }
}