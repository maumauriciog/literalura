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
                    \n------------------------------------------------------:
                       1 - Buscar Livro pelo Título
                       2 - Listar Livros Registrados
                       3 - Listar Autores Registrados
                       4 - Listar Autores Vivos em um Determinado Ano
                       5 - Listar Livros em um Determinado Idioma
                       0 - Sair
                    """);
            System.out.print("-> Escolha uma Opção: ");
            opcao = imput.nextInt();
            imput.nextLine();
        }
    }
}
