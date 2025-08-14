package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.DTO.AutorDTO;
import br.com.alura.Literalura.DTO.InfoLivros;
import br.com.alura.Literalura.DTO.LivroDTO;
import br.com.alura.Literalura.entidades.Autor;
import br.com.alura.Literalura.entidades.Idioma;
import br.com.alura.Literalura.entidades.Livro;
import br.com.alura.Literalura.repositorio.AutorRepositorio;
import br.com.alura.Literalura.repositorio.LivrosRepositorio;
import br.com.alura.Literalura.servico.ConsumoAPI;
import br.com.alura.Literalura.servico.ConverteDados;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class Principal {
    @Autowired
    private final LivrosRepositorio livrosRepositorio;

    @Autowired
    private final AutorRepositorio autorRepositorio;

    Scanner imput = new Scanner(System.in);

    private static final String URL = "https://gutendex.com/books?search=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private String json;

    int exit = 0;

    public Principal(LivrosRepositorio livrosRepositorio, AutorRepositorio autorRepositorio) {
        this.livrosRepositorio = livrosRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    private String menu = """
            \n------------------------------------------------------:
               1 - Buscar Livro pelo Título
               2 - Listar Livros Registrados
               3 - Listar Autores Registrados
               4 - Listar Autores Vivos em um Determinado Ano
               5 - Listar Livros em um Determinado Idioma
               0 - Sair
            
               -> Escolha uma Opção:
            """;

    public void Menu() {
        var opcao = -1;
        while (opcao != 0) {
            System.out.print(menu);
            opcao = imput.nextInt();
            imput.nextLine();
            switch (opcao) {
                case 1:
                    buscarLivroPorTitulo();
                    break;
                case 2:
//                    buscarPorAPI();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                default:
                    System.out.println("----- opção inválida -----");
            }
        }
    }


//    private void buscarLivroPorTitulo() {
//        System.out.print("-> Qual o nome do livro para a busca: ");
//        String nomeLivro = imput.nextLine();
//
//        Optional<Livro> livroNoBanco = livrosRepositorio.findByTituloContainingIgnoreCase(nomeLivro);
//
//        if (livroNoBanco.isPresent()) {
//            System.out.println("----- Este Livro consta Cadastrado -----");
//            System.out.println(livroNoBanco.get());
//        } else {
//            try {
//                json = consumoAPI.obterDados(URL + nomeLivro);
//                InfoLivros infoLivros = conversor.obterDados(json, InfoLivros.class);
//
//                Optional<LivroDTO> dadosLivrosDTO = infoLivros.resultados()
//                        .stream()
//                        .filter(l -> l.titulo().equalsIgnoreCase(nomeLivro))
//                        .findFirst();
//
//                if (dadosLivrosDTO.isPresent()) {
//                    LivroDTO dadosLivros = dadosLivrosDTO.get();
//                    Autor autor;
//
//                    if (!dadosLivros.autor().isEmpty()) {
//                        AutorDTO dadosAutor = dadosLivros.autor().get(0);
//
//                        Optional<Autor> autorExistente = autorRepositorio.findByNomeContainingIgnoreCase(dadosAutor.nome());
//                        autor = autorExistente.orElseGet(() -> {
//                            Autor novoAutor = new Autor();
//                            novoAutor.setNome(dadosAutor.nome());
//                            novoAutor.setAnoNascimento(dadosAutor.anoDeNascimento());
//                            novoAutor.setAnoFalecimento(dadosAutor.anoFalecimento());
//                            return novoAutor;
//                        });
//                    } else {
//                        autor = autorRepositorio.findByNomeContainingIgnoreCase("Desconhecido")
//                                .orElseGet(() -> {
//                                    Autor autorDesconhecido = new Autor();
//                                    autorDesconhecido.setNome("Desconhecido");
//                                    return autorDesconhecido;
//                                });
//                    }
//
//                    Livro novoLivro = new Livro();
//                    novoLivro.setTitulo(dadosLivros.titulo());
//                    novoLivro.setIdioma(dadosLivros.idiomas());
//                    novoLivro.setnDownloads(dadosLivros.nDownloads());
//
//    //                  novoLivro.getAutores()(dadosLivros.autor());
//                    livrosRepositorio.save(novoLivro);
//
//                    System.out.println("\n------ Livro SALVO com sucesso!");
//                }else{
//                    System.out.println("---- LIVRO INFORMADO NÃO ENCONTRADO -----");
//                }
//            } catch (Exception e) {
//                System.out.println("----- ALGO DEU ERRADO AO TENTAR BUSCAR O LIVRO INFORMADO ----- " + e.getMessage());
//            }
//        }
//    }

    private void buscarLivroPorTitulo() {
        System.out.print("-> Qual o nome do livro para a busca: ");
        String nomeLivro = imput.nextLine();

        json = consumoAPI.obterDados(URL + nomeLivro.toLowerCase().replace(" ", "%20"));
        InfoLivros listaLivros = conversor.obterDados(json, InfoLivros.class);

        if (listaLivros.resultados() != null && !listaLivros.resultados().isEmpty()) {
            Optional<LivroDTO> dadosLivrosDTO = listaLivros.resultados()
                    .stream()
                    .filter(l -> l.titulo().equalsIgnoreCase(nomeLivro))
                    .findFirst();

            if(dadosLivrosDTO.isPresent()){
                LivroDTO livro = dadosLivrosDTO.get();
                Autor autor;
            }

        } else {
            System.out.println("Nenhum livro encontrado com esse nome.");
        }
    }



}