package erguerra.core_eng.tema_1;

public class Main {
    public static void main(String[] args) {
        LampadaLed led = new LampadaLed("vermelho");
        LampadaFluorescente fluorescente = new LampadaFluorescente(100);
        Interruptor interruptorLed = new Interruptor(led);
        Interruptor interruptorFluorescente = new Interruptor(fluorescente);

        interruptorLed.trocarEstadoLampada();
        interruptorLed.trocarEstadoLampada();
        interruptorFluorescente.trocarEstadoLampada();
        interruptorFluorescente.trocarEstadoLampada();
    }
}
