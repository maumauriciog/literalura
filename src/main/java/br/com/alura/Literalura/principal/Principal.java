package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.repositorio.LivrosRepositorio;

import java.util.Scanner;

public class Principal {
    private final LivrosRepositorio repositorio;

    Scanner imput = new Scanner(System.in);
    int exit = 0;

    public Principal (LivrosRepositorio repositorio){
        this.repositorio = repositorio;
    }

    public void Menu(){
        var opcao = 0;

        while (opcao != 9){
            System.out.println("""
                    \n-> Escolha uma Opção:
                    \n1 - Buscar Livro pelo Título
                    \n2 - Listar Livros Registrados
                    \n3 - Listar Autores Registrados
                    \n4 - Listar Autores Vivos em um Determinado Ano
                    \n5 - Listar Livros em um Determinado Idioma
                    \n0 - Sair
                    """);
        }
    }
}
