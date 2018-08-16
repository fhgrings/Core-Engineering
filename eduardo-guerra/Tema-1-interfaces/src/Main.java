public class Main {

    /*
    O importante é perceber que podemos adicionar lampadas de dois tipos em uma lista de Lampadas por se tratar de uma
    interface.
     */
    public static void main(String[] args) {

        LampadaLed led = new LampadaLed("Vermelho");
        LampadaLed led1 = new LampadaLed("Verde");
        LampadaLed led2 = new LampadaLed("Azul");
        LampadaFluor fluor = new LampadaFluor(50);
        LampadaFluor fluor1 = new LampadaFluor(40);
        LampadaFluor fluor2 = new LampadaFluor(30);


        LightingSystem ls = new LightingSystem(led);

        ls.addLampada(led1);
        ls.addLampada(led2);
        //mesmo adicionando lâmpadas de tipos diferentes, não há erro de execução devido ao uso da interface
        ls.addLampada(fluor);
        ls.addLampada(fluor1);
        ls.addLampada(fluor2);
        ls.showNumLampadas();
        led.on();
        led.off();
        fluor.on();
        fluor.off();
        ls.switchTarzan(2); //switch era reservado do Java
        ls.switchTarzan(4);
        ls.switchTarzan(2);
        ls.switchTarzan(4);

    }
}
