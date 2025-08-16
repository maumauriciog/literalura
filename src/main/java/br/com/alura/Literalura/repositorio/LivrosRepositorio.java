package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivrosRepositorio extends JpaRepository<Livro, Long> {

    @Query(value = "SELECT * FROM livros WHERE :idioma = ANY(idioma)", nativeQuery = true)
    List<Livro> ListarPorIdioma(String idioma);
}