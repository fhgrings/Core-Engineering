package erguerra.core_eng.tema_3_lampada;

public class Main {
    public static void main(String[] args) {
        LampadaLed led = new LampadaLed("vermelho");
        LampadaFluorescente fluorescente = new LampadaFluorescente(100);
        Interruptor interruptorLed = new Interruptor(led);
        Interruptor interruptorFluorescente = new Interruptor(fluorescente);

        System.out.println(interruptorLed.trocarEstado());
        System.out.println(interruptorLed.trocarEstado());
        System.out.println(interruptorFluorescente.trocarEstado());
        System.out.println(interruptorFluorescente.trocarEstado());
    }
}