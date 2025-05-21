package com.mycompany.trabalho1.equipe8;

public abstract class Celula {
    
    protected boolean viva;
    
    public boolean taViva(){ // Método que diz se a célula tá viva ou não, retornando o valor atual da variável viva
        return viva;
    }
    
    public void setViva(boolean viva){ // Método que muda o estado das células
        this.viva = viva; 
    }
    
    public abstract Celula evolucao(int vizinhosVivos); // Método que vai definir se a célula vive ou morre com base na quantidade de vizinhos vivos
    public abstract char simbolo(); // Método pra pegar o símbolo que representa a célula
    
}
