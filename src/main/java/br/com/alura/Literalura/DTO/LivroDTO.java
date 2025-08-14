package br.com.alura.Literalura.DTO;

import br.com.alura.Literalura.entidades.Idioma;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDTO> autor,
        @JsonAlias("languages") Idioma idiomas,
        @JsonAlias("download_count") Integer nDownloads
        ) {

}
