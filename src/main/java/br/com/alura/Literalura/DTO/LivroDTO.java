package br.com.alura.Literalura.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<AutorDTO> autor,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") int nDownloads
        ){

        public String validarIdioma(){
                if(idioma!=null && idioma.isEmpty()){
                        return idioma.get(0);
                }else{
                        return "Desconhecido";
                }
        }

        @Override
        public String toString() {
                return "    -> Título: " + titulo + "\n" +
                        "    -> Autor: " + autor + "\n" +
                        "    -> Idioma: " + idioma + "\n" +
                        "    -> N. Downoads: " + nDownloads + "\n\n          -----\n";
        }
}
