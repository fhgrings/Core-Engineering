public class main {



    public static void main (String[] args){

        Lampada led = new LED();
        Lampada Incandescente = new Incandescente();

        interruptor interruptorLed = new interruptor(led);
        interruptor interruptorIncandescente = new interruptor(Incandescente);



        System.out.println("Lampada led está ligada: " + led.verificacao());
        System.out.println("Lampada Incandescente está ligada: " + Incandescente.verificacao());



        interruptorLed.switchLampada();
        interruptorIncandescente.switchLampada();

        System.out.println("Lampada led está ligada: " + led.verificacao());
        System.out.println("Lampada Incandescente está ligada: " + Incandescente.verificacao());



        interruptorLed.switchLampada();
        interruptorIncandescente.switchLampada();

        System.out.println("Lampada led está ligada: " + led.verificacao());
        System.out.println("Lampada Incandescente está ligada: " + Incandescente.verificacao());


        interruptorLed.switchLampada();
        interruptorIncandescente.switchLampada();

        System.out.println("Lampada led está ligada: " + led.verificacao());
        System.out.println("Lampada Incandescente está ligada: " + Incandescente.verificacao());


    }
}
