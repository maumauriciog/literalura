package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.repositorio.AutorRepositorio;
import br.com.alura.Literalura.repositorio.LivrosRepositorio;
import br.com.alura.Literalura.service.ConsumoAPI;
import br.com.alura.Literalura.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class Principal {
    @Autowired
    private final LivrosRepositorio livrosRepositorio;

    @Autowired
    private final AutorRepositorio autorRepositorio;

    private static final String URL = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private String json;

    Scanner imput = new Scanner(System.in);
    int exit = 0;

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

    public Principal(LivrosRepositorio livrosRepositorio, AutorRepositorio autorRepositorio) {
        this.livrosRepositorio = livrosRepositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void Menu() {
        var opcao = -1;

        while (opcao != 0) {
            json = consumoAPI.obterDados(URL);
            System.out.println(menu);
            opcao = imput.nextInt();
            imput.nextLine();

            switch (opcao) {
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("----- opção inválida -----");
            }
        }
    }
}
