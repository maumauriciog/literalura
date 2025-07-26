package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

}
