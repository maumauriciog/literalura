package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivrosRepositorio extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l JOIN FETCH l.autor WHERE l.idioma = :idioma")
    List<Livro> findByIdioma(String idioma);
}