# 🧬 Jogo da Vida em Java — Versão Adaptada

Uma adaptação do clássico **"Jogo da Vida"** de John Horton Conway, programada em **Java**, utilizando conceitos de **Programação Orientada a Objetos (POO)** e diferentes tipos de células, o que adiciona complexidade e novas estratégias à simulação.

## 🎮 Sobre o Projeto

Este projeto simula a evolução de um ecossistema celular em um tabuleiro, onde cada célula pode nascer, sobreviver ou morrer de acordo com a quantidade de vizinhos vivos. Ao contrário da versão original, aqui temos **múltiplos tipos de células**, cada uma com regras próprias de evolução.

O foco principal está no uso de **encapsulamento, herança, polimorfismo e abstração**, pilares da POO, aplicados de forma prática em um jogo interativo via console.

## 🚀 Funcionalidades

- Simulação baseada em gerações.
- Células com comportamentos personalizados:
  - **Clássica**: segue as regras originais de Conway.
  - **Forte**: mais resistente, sobrevive com mais vizinhos.
  - **Tímida**: morre facilmente se cercada.
  - **Matemática**: reage à paridade dos vizinhos vivos.
  - **Borda**: células fixas que nunca vivem (usadas para delimitar o tabuleiro).
- Tabuleiro de qualquer tamanho.
- Interface textual simples e clara.

## 🧱 Estrutura do Código

### `Celula.java`
Classe abstrata base que representa uma célula genérica. Define:
- Se a célula está viva ou morta.
- Métodos para matar, reviver, verificar estado e obter símbolo.
- Método abstrato `evoluir(int vizinhosVivos)`.

### Subclasses de Células

 - **Clássica (`+`)**  
    - Se estiver viva:
      - Sobrevive com 2 ou 3 vizinhos vivos.
      - Morre com menos de 2 (isolamento) ou mais de 3 (superpopulação).  
    - Se estiver morta:
      - Torna-se viva se tiver exatamente 3 vizinhos vivos.

  - **Forte (`@`)**   
    - Se estiver viva:
      - Continua viva com 2 ou mais vizinhos vivos.
      - Morre apenas se tiver menos de 2.  
    - Se estiver morta:
      - Torna-se viva apenas se tiver mais que 4 vizinhos vivos.

  - **Tímida (`&`)**  
    - Se estiver viva:
      - Permanece viva **somente se nenhum vizinho estiver vivo**.
      - Caso contrário, morre.  
    - Se estiver morta:
      - Torna-se viva **apenas se todos os vizinhos estiverem mortos**.
      - Caso contrário, continua morta.

  - **Matemática (`#`)**  
    - Se estiver viva:
      - Permanece viva **se o número de vizinhos vivos for ímpar**.
      - Caso contrário, morre.  
    - Se estiver morta:
      - Torna-se viva **se o número de vizinhos vivos for par**.
      - Caso contrário, permanece morta.

  - **Borda (`.`)**  
    Células fixas que estão **sempre mortas** e **não evoluem**.  
    Usadas nas bordas do tabuleiro para simplificar a lógica das vizinhanças.

Cada tipo possui um símbolo distinto para facilitar a visualização no tabuleiro.

### `Tabuleiro.java`
Gerencia o estado geral do jogo:
- Armazena a matriz de células.
- Conta os vizinhos vivos.
- Atualiza as células para a próxima geração.
- Exibe o tabuleiro no console.

### `JogoDaVida.java`
Classe principal:
- Inicializa o tabuleiro com as células desejadas.
- Controla o ciclo de gerações.
- Executa a simulação.

## 📷 Exemplo (Console)

### `Entrada:`

```
5 5
@ @ @ @ @
@ @ @ @ @
@ @ @ @ @
@ @ @ @ @
@ @ @ @ @
0 0 1 0 0
1 0 0 0 0
1 0 1 0 0
0 1 0 1 0
0 0 0 0 0
1

```

### `Saída:`

```
. . . . . . .     
. . . @ . . . 
. @ . . . . . 
. @ . @ . . . 
. . @ . @ . . 
. . . . . . . 
. . . . . . .

```

### `Pós Iteração:`

```

. . . . . . . 
. . . . . . . 
. . . . . . . 
. @ . @ . . . 
. . @ . . . . 
. . . . . . . 
. . . . . . . 

```

Cada célula é representada por um caractere:
- `'@'`: célula viva
- `'.'`: célula morta

## 🧑‍🏫 Sobre o Trabalho

Este projeto foi desenvolvido como **trabalho em dupla** para a disciplina de **Programação Orientada a Objetos** no curso de graduação de **Ciência da Computação** da **UNESPAR (Universidade Estadual do Paraná)**.

## 🧑‍💻 Autoria

Desenvolvido por:

- **Christiano Miquelão Bosso**
- **Maria Luiza Ayumi Saito Yoshiura** (https://github.com/MariaLyoshiura)

Projeto com fins acadêmicos e didáticos, voltado à prática dos conceitos de orientação a objetos em Java.
