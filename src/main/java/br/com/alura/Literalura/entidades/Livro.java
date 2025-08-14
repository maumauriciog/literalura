package br.com.alura.Literalura.entidades;

import br.com.alura.Literalura.DTO.LivroDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer nDownloads;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Autor autores;

    public Livro() { }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.titulo();
        this.autores = (Autor) livroDTO.autor();
        this.idioma = Idioma.deGutendex(livroDTO.idiomas().name());
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

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getnDownloads() {
        return nDownloads;
    }

    public void setnDownloads(Integer nDownloads) {
        this.nDownloads = nDownloads;
    }

    public Autor getAutores() {
        return autores;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", idioma=" + idioma +
                ", nDownloads=" + nDownloads +
                ", autores=" + autores +
                '}';
    }
}