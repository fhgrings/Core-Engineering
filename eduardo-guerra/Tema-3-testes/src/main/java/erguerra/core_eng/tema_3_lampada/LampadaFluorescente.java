package erguerra.core_eng.tema_3_lampada;

public class LampadaFluorescente implements Lampada {

    private boolean ligada = false;
    private int potencia;

    public LampadaFluorescente(int potencia) {
        this.potencia = potencia;
    }

    public void ligar() {
        ligada = true;
    }

    public void desligar() {
        ligada = false;
    }
}

