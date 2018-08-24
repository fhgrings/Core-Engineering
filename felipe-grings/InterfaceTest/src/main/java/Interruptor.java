public class Interruptor {

    private Lampada lampada;
    private boolean verificacao;

    public Interruptor(Lampada lampada) {
        this.lampada = lampada;
        this.verificacao = false;
    }

    public void inverter() {

        if (verificacao == false) {
            lampada.on();
            verificacao = true;
        } else {
            lampada.off();
            verificacao = false;
        }
    }

    public boolean isVerificacao(){
        return verificacao;
    }

}


