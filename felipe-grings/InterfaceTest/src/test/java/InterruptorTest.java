import org.junit.Assert;
import org.junit.Test;


public class InterruptorTest {

    @Test
    public void shouldCreateLEDandReturnoff() {
        Lampada led = new LED();
        Interruptor interruptorLed = new Interruptor(led);


        Assert.assertFalse("should be false",interruptorLed.isVerificacao());

    }

    @Test
    public void shouldInvertandReturnOn() {
        Lampada led = new LED();
        Interruptor interruptorLed = new Interruptor(led);

        interruptorLed.inverter();
        Assert.assertTrue("should be True",interruptorLed.isVerificacao());

    }




}