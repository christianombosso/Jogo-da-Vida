package com.mycompany.trabalho1.equipe8;

public class CelulaTimida extends Celula {
    
    @Override
    
    public Celula evolucao(int vizinhosVivos){
        
        CelulaTimida novaCelula = new CelulaTimida();
        
        if (!viva){
            if (vizinhosVivos == 0){
                novaCelula.setViva(true); // Se a célula ta morta mas não tem vizinhos vivos, ela revive (regra 2)
            } else {
                novaCelula.setViva(false); // Caso contrário continua morta
            }
        } else {
            if (vizinhosVivos == 0){
                novaCelula.setViva(true); // Se a célula ta viva e não tem nenhum vizinho vivo, ela continua viva (regra 1)
            } else {
                novaCelula.setViva(false); // Caso contrário ela morre por timidez kkkk
            }
        }
        
        return novaCelula;
        
}
    
    @Override
    
    public char simbolo(){
        if (viva){
            return '&'; // Se a célula tiver viva, retorna o símbolo dela (Célula Tímida = &)
        } else {
            return '.'; // Se não, retorna o símbolo de célula morta (.)
        }
    }
}
