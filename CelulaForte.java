    package com.mycompany.trabalho1.equipe8;

    public class CelulaForte extends Celula {

        @Override

        public Celula evolucao(int vizinhosVivos){

            CelulaForte novaCelula = new CelulaForte();

            if (!viva){
                if (vizinhosVivos > 4){
                    novaCelula.setViva(true); // Se a célula ta morta mas tem mais de 4 vizinhos vivos, ela revive (regra 2)
                } else {
                    novaCelula.setViva(false); // Caso contrário continua morta
                }
            } else {
                if (vizinhosVivos >= 2){
                    novaCelula.setViva(true); // Se a célula ta viva e tem 2 ou mais vizinhos vivos, ela continua viva (regra 1)
                } else {
                    novaCelula.setViva(false); // Caso contrário ela morre por isolamento
                }
            }

            return novaCelula;

    }

        @Override

        public char simbolo(){
            if (viva){
                return '@'; // Se a célula tiver viva, retorna o símbolo dela (Célula Forte = @)
            } else {
                return '.'; // Se não, retorna o símbolo de célula morta (.)
            }
        }
    }