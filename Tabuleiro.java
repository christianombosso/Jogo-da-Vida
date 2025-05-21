import java.util.Scanner;

public class Tabuleiro {

    public void iniciarJogo(Scanner scanner) {

        int linhas = scanner.nextInt(); // Definindo o tamanho do tabuleiro sem as bordas
        int colunas = scanner.nextInt();

        int totalLinhas = linhas + 2; // Adicionando as bordas
        int totalColunas = colunas + 2;

        Celula[][] tabuleiro = new Celula[totalLinhas][totalColunas];

        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                tabuleiro[i][j] = new CelulaBorda(); // Deixando o tabuleiro inteiro como células de borda pra depois ir adicionando as outras células
            }
        }

        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= colunas; j++) {
                char tipo = scanner.next().charAt(0);
                switch (tipo) {
                    case '+':
                        tabuleiro[i][j] = new CelulaClassica();
                        break;
                    case '@':
                        tabuleiro[i][j] = new CelulaForte();
                        break;
                    case '&':
                        tabuleiro[i][j] = new CelulaTimida();
                        break;
                    case '#':
                        tabuleiro[i][j] = new CelulaMatematica();
                        break;
                    default:
                        System.out.println("Esse tipo de celula nao existe!");
                        return;
                }
            }
        }

        // Lendo o estado inicial de todas as células internas do tabuleiro sem as bordas
        
        for (int i = 1; i <= linhas; i++) {
            for (int j = 1; j <= colunas; j++) {
                int estado = scanner.nextInt();
                tabuleiro[i][j].setViva(estado == 1);
            }
        }

        int iteracoes = scanner.nextInt();

        mostrarTabuleiro(tabuleiro);

        for (int iterar = 0; iterar < iteracoes; iterar++) {
            System.out.println();
            tabuleiro = proximaGeracao(tabuleiro);
            mostrarTabuleiro(tabuleiro);
        }
    }
    
    // Função que recebe o tabuleiro atual e vai gerar a próxima geração de células
    
    public Celula[][] proximaGeracao(Celula[][] tabuleiroAtual) {

        int linhas = tabuleiroAtual.length;
        int colunas = tabuleiroAtual[0].length;

        Celula[][] proximoTabuleiro = new Celula[linhas][colunas];
        
        // Preenchendo as bordas do novo tabuleiro com as células de borda
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (i == 0 || i == linhas - 1 || j == 0 || j == colunas - 1) { 
                    proximoTabuleiro[i][j] = new CelulaBorda();
                }
            }
        }
        
        // Evoluindo as células internas do novo tabuleiro
        
        for (int i = 1; i < linhas - 1; i++) {
            for (int j = 1; j < colunas - 1; j++) {
                int vivos = contarVivos(tabuleiroAtual, i, j);
                proximoTabuleiro[i][j] = tabuleiroAtual[i][j].evolucao(vivos);
            }
        }

        return proximoTabuleiro;
    }
    
    // Função para contar os vizinhos vivos
    
    public int contarVivos(Celula[][] tabuleiro, int linha, int coluna) {
        
        int vivos = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (tabuleiro[linha + i][coluna + j].taViva()) {
                    vivos++;
                }
            }
        }

        return vivos;
    }
    
    // Funcao para imprimir os tabuleiros 
    
    public void mostrarTabuleiro(Celula[][] tabuleiro) {
        int linhas = tabuleiro.length;
        int colunas = tabuleiro[0].length;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(tabuleiro[i][j].simbolo() + " ");
            }
            System.out.println();
        }
    }
}
