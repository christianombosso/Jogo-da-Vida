package com.mycompany.trabalho1.equipe8;

public class CelulaClassica extends Celula {
    
    @Override
    
    public Celula evolucao(int vizinhosVivos){
        
        CelulaClassica novaCelula = new CelulaClassica();
        
        if (!viva){
            if (vizinhosVivos == 3) {
                novaCelula.setViva(true); // Se a célula ta morta mas tem 3 vizinhos vivos, ela revive (regra 1)
            } else {
                novaCelula.setViva(false); // Caso contrário continua morta
            }
        } else {
            if (vizinhosVivos == 2 || vizinhosVivos == 3){ // Se a celula ta viva e tem 2 ou 3 vizinhos vivos, ela continua viva (regra 4)
                novaCelula.setViva(true);
            } else {
                novaCelula.setViva(false); // Caso contrario morre por isolamento ou superpopulacao (regras 2 e 3)
            }
        }
        
        return novaCelula;
        
    }
    
    @Override
    
    public char simbolo(){
        if (viva){
            return '+'; // Se a célula tiver viva, retorna o símbolo dela (Célula Clássica = +)
        } else {
            return '.'; // Se não, retorna o símbolo de célula morta (.)
        }
    }
    
}
