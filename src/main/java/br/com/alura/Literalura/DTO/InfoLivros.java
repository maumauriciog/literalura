package br.com.alura.Literalura.DTO;

import br.com.alura.Literalura.entidades.Livro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InfoLivros(@JsonAlias("results") List<LivroDTO> result) {

}