package com.mycompany.trabalho1.equipe8;

import java.util.Scanner;

public class JogoDaVida{
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        Tabuleiro novotabuleiro = new Tabuleiro();
        novotabuleiro.iniciarJogo(scanner);

        scanner.close();
    }
}
