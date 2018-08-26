package erguerra.core_eng.tema_3_testes;

import erguerra.core_eng.tema_3_lampada.Interruptor;
import erguerra.core_eng.tema_3_lampada.LampadaFluorescente;
import erguerra.core_eng.tema_3_lampada.LampadaLed;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterruptorTests {
     @Test
    public void ligarUmaLedDesligada(){

        LampadaLed led = new LampadaLed("Vermelho");

        Interruptor interruptor = new Interruptor(led);

        assertEquals("Lampada foi ligada", interruptor.trocarEstado());
    }

    @Test
    public void apagarUmaLedLigada(){

        LampadaLed led = new LampadaLed("vermelho");

        Interruptor interruptor = new Interruptor(led);

        interruptor.trocarEstado();

        assertEquals("Lampada foi desligada", interruptor.trocarEstado());
    }

    @Test
    public void ligarUmaFluorescenteDesligada(){

        LampadaFluorescente fluorescente = new LampadaFluorescente(100);

        Interruptor interruptor = new Interruptor(fluorescente);

        assertEquals("Lampada foi ligada", interruptor.trocarEstado());
    }

    @Test
    public void apagarUmaFluorescenteLigada(){

        LampadaFluorescente fluorescente = new LampadaFluorescente(100);

        Interruptor interruptor = new Interruptor(fluorescente);

        interruptor.trocarEstado();

        assertEquals("Lampada foi desligada", interruptor.trocarEstado());
    }


}
