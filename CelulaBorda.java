package com.mycompany.trabalho1.equipe8;

public class CelulaBorda extends Celula {
    
    public CelulaBorda(){
        this.viva = false; // Ta sempre morta
    }
    
    @Override
    
    public Celula evolucao(int vizinhosVivos){
        
        CelulaBorda novaCelula = new CelulaBorda();
        
        if(!viva){
            novaCelula.setViva(false); // Continua morta
        } else {
            novaCelula.setViva(false); // Se por algum erro ficar viva, o código mata ela kkkkkk
        }
        
        return novaCelula;
        
    }
    
    @Override
    
    public char simbolo(){
        return '.'; // Sempre vai retornar o símbolo de uma célula morta (.)
    }
}
