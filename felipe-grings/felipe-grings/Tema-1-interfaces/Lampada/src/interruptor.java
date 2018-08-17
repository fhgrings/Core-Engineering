public class interruptor {

    private Lampada lampada;

    public interruptor(Lampada lampada) {
        this.lampada = lampada;
    }



    public void switchLampada() {

        if (lampada.verificacao() == true) {

            lampada.off();


        } else {


            lampada.on();
        }

    }
}


