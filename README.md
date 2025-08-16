# LiterAlura&emsp;![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)<img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" /><img src="https://img.shields.io/badge/json-5E5C5C?style=for-the-badge&logo=json&logoColor=white" />
O Challenge LiterAlura, é um projeto final do curso de java - spring boot. Oferece interação textual (via console) com os usuários, proporcionando 5(cinco) opções distintas. Os livros são obtida por meio de uma API, garantindo informações precisas em tempo real para uma experiência mais atualizada e eficaz.

- **objetivo**

> Via console, o usuário vai entrar com a opção que deseja dentro desse menu, e depois disso vai informar qual é o valor que deseja converter.

- **o que encontrar**

> o usuário terá 05(cinco) opçoes de escolha para a pesquisa do livro, gravar no banco de dados e demais pesquisas.

- **customizável**

> o usuário vai poder realizar a pesquisa por livros quantas vezes for necessário, e enquanto o programa estiver em execução. Não há necessidade de encerrar o programa para obter uma nova consulta.

## Compilando e Executando o LiterAlura
Certifique-se de ter o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) e a biblioteca [guten](https://mvnrepository.com/search?q=GSON) instalado / baixado, e siga as instruções conforme abaixo:
1. Faça o download do código fonte:

```sh
https://github.com/maumauriciog/challenge_conversor_de_moedas
```

2. Instale a biblioteca GSON, após o download (instale após abrir o código fonte no intelliJ - o procódigo fonte precisa desta biblioteca instalada para garantir seu funcionamento):

&emsp;&emsp;<img src="pictures/scrA.png" width="210">&emsp;<img src="pictures/scrB.png" width="243">&emsp;<img src="pictures/scrC.png" width="238">

```
- vá ao menu File do intelliJ e escolha a opção 'Project Structure'
- click e 'Modules'
- click em 'Dependencies' no lado direito
- click no sinal de '+'
- click na opção 'JARs or Directories'
- selecione a biblioteca GSON baixada anteriormente
```

3. Execute o programa:
&emsp;&emsp;<img src="pictures/scrD.png" width="838">

```
- click em 'Run Main'
- ou Shift F10
```

> [!IMPORTANT]
> O programa funciona somente utilizando uma IDE, neste caso, o [intelliJ](https://www.jetbrains.com/idea/download/?section=windows) com a biblioteca [GSON](https://mvnrepository.com/search?q=GSON) instalada.

## Utilizando o Programa em Execução
O usuário terá de escolher uma das 05(cinco) opções disponíveis conforme abaixo:
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

-> Escolha uma opção válida: 1
-> Digite o valor que deseja converter: 100
```
```bash
     *** Resultado da Operação ***
     Valor de 100.0[BRL], corresponde ao valor final de 17.52[USD]
```

## Contribuindo
Esperamos que outras organizações possam se beneficiar do projeto. Agradecemos qualquer contribuição da comunidade.

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
