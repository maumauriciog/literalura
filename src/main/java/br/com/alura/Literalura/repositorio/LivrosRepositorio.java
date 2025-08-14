package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.entidades.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LivrosRepositorio extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTituloContainingIgnoreCase(String nomeLivro);

}
