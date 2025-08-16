package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.DTO.AutorDTO;
import br.com.alura.Literalura.DTO.InfoLivros;
import br.com.alura.Literalura.DTO.LivroDTO;
import br.com.alura.Literalura.entidades.Autor;
import br.com.alura.Literalura.entidades.Livro;
import br.com.alura.Literalura.repositorio.AutorRepositorio;
import br.com.alura.Literalura.repositorio.LivrosRepositorio;
import br.com.alura.Literalura.servico.ConsumoAPI;
import br.com.alura.Literalura.servico.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Component
public class Principal {
    @Autowired
    private final LivrosRepositorio livrosRepositorio;
    @Autowired
    private final AutorRepositorio autorRepositorio;

    Scanner imput = new Scanner(System.in);

    private static final String URL = "https://gutendex.com/books/?search=";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private String json;

    int exit = 0;

    public Principal(LivrosRepositorio livrosRepositorio, AutorRepositorio autorRepositorio) {
        this.livrosRepositorio = livrosRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    private String menu = """
            \n:----------------------------------------------------:
            :---      LITERALURA - PESQUISE SEU LIVRO        ----:
            :----------------------------------------------------:
               1 - Buscar Livro pelo Título
               2 - Listar Livros Registrados
               3 - Listar Autores Registrados
               4 - Listar Autores Vivos em um Determinado Ano
               5 - Listar Livros em Um Determinado Idioma
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
                    listaLivrosRegistrados();
                    break;
                case 3:
                    listaAutoresRegistrados();
                    break;
                case 4:
                    AutoresVivosNesteAno();
                    break;
                case 5:
                    LivroNoIdioma();
                    break;
                case 0:
                    System.out.println("\n-> Encerrando o programa !...\n");
                    break;
                default:
                    System.out.println("\n        <----- OPÇÃO INVÁLIDA ----->\n");
            }
        }
    }

    //Lista TODOS OS LIVROS NO IDIOMA ESPECIFICADO PELO USUÁRIO
    private void LivroNoIdioma() {
        System.out.println("-> Informe o Idioma do livro, opções conforme abaixo, para a Pesquisa: ");
        System.out.println("     EN (Inglês) - ES (espanhol) - FR (francês) ou PT (português) ");
        var idioma = imput.nextLine().trim().replaceAll("[^a-zA-Z\\-]", "");

        List<Livro> livros = livrosRepositorio.ListarPorIdioma(idioma);

        if (livros == null) {
            System.out.println("\n   ------- NÃO HÁ LIVROS COM O IDIOMA " + idioma + ", CADASTRADO NO BANCO DE DADOS -------");
        } else {
            System.out.println(livros.toString());
        }
    }

    //Lista TODOS OS AUTORES VIVOS no Ano especificado pelo usuário
    private void AutoresVivosNesteAno() {
        System.out.print("-> Informe o Ano Para a Pesquisa: ");
        var ano = imput.nextInt();
        imput.nextLine();

        List<Autor> autoresVivo = autorRepositorio.ListaAutoresVivosApartAno(ano);

        if (autoresVivo.isEmpty()) {
            System.out.println("\n   ------- NÃO HÁ REGISTRO DE AUTORES CADASTRADO NO BANCO DE DADOS -------");
        } else {
            System.out.println("\n  <------- Listando AUTORES VIVOS A PARTIR DO ANO DE " + ano + " do Banco de Dados ------->");
            System.out.println(autoresVivo.toString());
            ;
        }
    }


    //Lista todos os autores Registrados no Banco de Dados
    private void listaAutoresRegistrados() {
        List<Autor> autores = autorRepositorio.findAll();

        if (autores.isEmpty()) {
            System.out.println("\n     --- Nenhum AUTOR Encontrado ---");
        } else {
            System.out.println("\n     ------- LISTANDO AUTORES NO BANCO DE DADOS -------");
            System.out.println(autores);
        }
    }

    //Lista todos os livros registrados no Banco de Dados
    private void listaLivrosRegistrados() {
        Livro livro;
        List<Livro> livrosBD = livrosRepositorio.findAll();

        if (livrosBD.isEmpty()) {
            System.out.println("\n     --- Nenhum LIVRO Encontrado ---");
        } else {
            System.out.println("\n    ------- LIVROS ARMAZENADOS NO BANCO DE DADOS -------");
            livrosBD.stream()
                    .sorted(Comparator.comparing(l -> l.getTitulo()))
                    .forEach(System.out::println);
        }
    }

    //Busca livro na API, especificado pelo usuário, e grava no Banco de Dados
    private void buscarLivroPorTitulo() {
        System.out.print("   -> Qual o Nome do Livro para Busca: ");
        String nomeLivro = imput.nextLine();

        var json = consumoAPI.obterDados(URL + nomeLivro.toLowerCase().replace(" ", "%20"));
        InfoLivros resposta = conversor.obterDados(json, InfoLivros.class);

        if (resposta.result().isEmpty()) {
            System.out.println("\n    <----- NENHUM LIVRO ENCONTRADO COM ESTE NOME ! ----->");
        } else {
            System.out.println("\n    **** LIVRO ENCONTRADO ****");
            LivroDTO livrosDaAPI = resposta.result().get(0);
            Livro livrosEntity = AtribuindoLivroDTOParaEntity(livrosDaAPI);
            livrosRepositorio.save(livrosEntity);
            System.out.println(livrosDaAPI.toString());
        }
    }

    //Transferindo as informações do livro e autor da API para as entidades
    private Livro AtribuindoLivroDTOParaEntity(LivroDTO livrosDaAPI) {
        if (livrosDaAPI.autor().isEmpty()) {
            throw new RuntimeException("\n    <--- O LIVRO DEVE CONTER UM AUTOR, NO MÍNIMO ! --->");
        }
        Livro livro = new Livro();
        livro.setTitulo(livrosDaAPI.titulo());
        livro.setIdioma(Collections.singletonList(livrosDaAPI.validarIdioma()));
        livro.setnDownloads(livrosDaAPI.nDownloads());

        Autor autor = AtribuindoAutorDTOparaEntity(livrosDaAPI.autor().get(0));
        return livro;
    }

    private Autor AtribuindoAutorDTOparaEntity(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setNome(autorDTO.nome());
        autor.setAnoNascimento(autorDTO.anoDeNascimento());
        autor.setAnoFalecimento(autorDTO.anoFalecimento());
        autorRepositorio.save(autor);

        return autor;
    }
}