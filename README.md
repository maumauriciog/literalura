# LiterAlura&emsp;![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" /><img src="https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white" />
O Challenge LiterAlura, é um projeto final do curso de java - spring boot. Oferece interação textual (via console) com os usuários, proporcionando 5(cinco) opções distintas. Os livros são obtida por meio de uma API, garantindo informações precisas em tempo real para uma experiência mais atualizada e eficaz.

- **objetivo**

> Pesquisar um determinado livro e salvar no banco de dados, e realizar pesquisas conforme opções no menu.

- **o que encontrar**

> o usuário terá 05(cinco) opçoes de escolha para a pesquisa do livro, gravar no banco de dados, visualizar todos os livros que estão no banco de dados, listar autores, pesquisar autores não falecidos, e buscar livro por uma determinada linguagem.

- **customizável**

> o usuário vai poder realizar a pesquisa e esolher qualquer opção, enquanto o programa estiver em execução. Não há necessidade de encerrar o programa para obter uma nova consulta e armazenar o livro.

- **Tecnologias**

> Java - Spring Boot - JPA/Hibernate - API Gutendex.

## Compilando e Executando o LiterAlura
Certifique-se de ter o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) e o [pgAdmin4](https://www.pgadmin.org/download/) instalado em seu computador. Siga as instruções abaixo:
1. Faça o download do código fonte, depois descompacte o arquivo:

```sh
https://github.com/maumauriciog/literalura
```

2. Abra o programa pgAdmin4 e crie o banco de dados chamado literalura.

3. Execute o programa intelliJ e abra a pasta do código fonte baixado.

4. Aguarde até sincronizar todas as dependências.

> [!IMPORTANT]
> O programa funciona somente utilizando uma IDE, neste caso, o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) com o administrador de banco de dados [pgAdmin4](https://www.pgadmin.org/download/) instalado.

## Utilizando o Programa em Execução
O usuário poderá escolher uma das 05(cinco) opções disponíveis conforme abaixo:
```bash
-----------------------------------------------
---    LITERALURA - PESQUISE SEU LIVRO      ---
-----------------------------------------------
   1 - Buscar Livro pelo Título
   2 - Listar Livros Registrados
   3 - Listar Autores Registrados
   4 - Listar Autores Vivos em um Determinado Ano
   5 - Listar Livros em Um Determinado Idioma
   0 - Sair

-> Escolha uma opção: 1
-> Qual o Nome do Livro para a Busca: emma
```
```bash
**** LIVRO ENCONTRADO ****
    -> Título: Emma
    -> Autor:  Austen, Jane, anoDeNascimento=1775, anoFalecimento=1817
    -> Idioma: [en]
    -> N. Downoads: 69806

          -----
```

## Contribuindo
Esperamos que outras organizações / usuários possam se beneficiar do projeto. Agradecemos qualquer contribuição da comunidade.

## Contato
Temos os seguintes canais para contato:
- maumauriciog@hotmail.com
  - `no campo Assunto escreva: Ajuda` para assuntos de como utilizar o sistema; e
  - `no campo Assunto escreva: Quero Contribuir` para aqueles que desejam contribuir.
- [GitHub](https://github.com/maumauriciog)


## Licensa
```
The MIT License (MIT)

Copyright (c) 2025 Maurício Gomes das Chagas

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
