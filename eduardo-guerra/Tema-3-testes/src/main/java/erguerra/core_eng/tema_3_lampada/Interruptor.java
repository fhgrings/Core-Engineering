package erguerra.core_eng.tema_3_lampada;

public class Interruptor {

    private boolean ligada = false;
    private Lampada lampada;

    public Interruptor(Lampada lampada){
        this.lampada = lampada;
    }

    public String trocarEstado(){
         if(ligada) {
             lampada.desligar();
             ligada = false;
             return("Lampada foi desligada");
         }
         else{
             lampada.ligar();
             ligada = true;
             return("Lampada foi ligada");
         }
    }

}
