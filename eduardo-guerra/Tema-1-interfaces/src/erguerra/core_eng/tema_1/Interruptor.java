package erguerra.core_eng.tema_1;

public class Interruptor {

    private boolean ligada = false;
    private Lampada lampada;

    public Interruptor(Lampada lampada){
        this.lampada = lampada;
    }

    public void trocarEstadoLampada(){ //switch não foi possível por ser palavra reservada do Java
         if(ligada) {
             lampada.desligar();
             ligada = false;
             System.out.println("Lampada foi desligada");
         }
         else{
             lampada.ligar();
             ligada = true;
             System.out.println("Lampada foi ligada");
         }
    }

}
