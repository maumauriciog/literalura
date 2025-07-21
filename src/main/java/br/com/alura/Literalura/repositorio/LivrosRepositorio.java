package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepositorio extends JpaRepository<Livros, Long> {

}
