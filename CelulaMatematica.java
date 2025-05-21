public class CelulaMatematica extends Celula {
    
    @Override
    
    public Celula evolucao(int vizinhosVivos){
        
        CelulaMatematica novaCelula = new CelulaMatematica();
        
        if (!viva){
            if (vizinhosVivos % 2 == 0){
                novaCelula.setViva(true); // Se a célula ta morta mas tem um numero par de vizinhos vivos, ela revive (regra 2)
            } else {
                novaCelula.setViva(false); // Caso contrário continua morta
            }
        } else {
            if (vizinhosVivos % 2 != 0){
                novaCelula.setViva(true); // Se a célula ta viva e tem um numero ímpar de vizinhos vivos, ela continua viva (regra 1)
            } else {
                novaCelula.setViva(false); // Caso contrário ela morre
            }
        }
        
        return novaCelula;
        
}
    
    @Override
    
    public char simbolo(){
        if (viva){
            return '#'; // Se a célula tiver viva, retorna o símbolo dela (Célula Matemática = #)
        } else {
            return '.'; // Se não, retorna o símbolo de célula morta (.)
        }
    }
}
