package br.com.alura.Literalura.repositorio;

import br.com.alura.Literalura.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepositorio extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :ano AND (a.anoFalecimento >= :ano)")
    List<Autor> ListaAutoresVivosApartAno(int ano);

}