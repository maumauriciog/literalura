package br.com.alura.Literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDTO> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") int nDownloads
        ){

        public String validarIdioma(){
                if(idioma!=null && idioma.isEmpty()){
                        return idioma.get(0);
                }else{
                        return null;
                }
        }

        @Override
        public String toString() {
                return "\n----------------------------\n" +
                        "---- Livro Encontrado -----\n" +
                        "-\n" +
                        "---> Título: " + titulo + "\n" +
                        "---> Autor: " + autor + "\n" +
                        "---> Idioma: " + validarIdioma() + "\n" +
                        "---> N. Downoads: " + nDownloads + "\n";
        }
}
