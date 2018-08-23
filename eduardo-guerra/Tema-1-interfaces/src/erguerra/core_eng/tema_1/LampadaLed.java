package erguerra.core_eng.tema_1;

public class LampadaLed implements Lampada{

    private boolean ligada = false;
    private String cor;

    public LampadaLed(String cor){
        this.cor = cor;
    }
    public void ligar(){
        this.ligada = true;
    }
    public void desligar(){
        this.ligada = false;
    }
}

