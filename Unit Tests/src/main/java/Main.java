public class Main {

    public static void main (String[] args){

        Lampada led = new LED();
        Lampada Incandescente = new Incandescente();

        Interruptor interruptorLed = new Interruptor(led);
        Interruptor interruptorIncandescente = new Interruptor(Incandescente);


        interruptorLed.inverter();
        interruptorIncandescente.inverter();


        interruptorLed.inverter();
        interruptorIncandescente.inverter();


    }
}
