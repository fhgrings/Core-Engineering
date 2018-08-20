public class Main {

    public static void main(String args[]) {

        Lampada lampada = new Incandescente();
        Abajur abajur = new Abajur(lampada);

        print(abajur);

        abajur.switchLampada();

        print(abajur);

        lampada = new LED();
        abajur = new Abajur(lampada);

        print(abajur);

        abajur.switchLampada();

        print(abajur);

    }

    private static void print(Abajur abajur) {
        System.out.println("Abajur " + abajur.tipo() + " ligado: " + abajur.isOn());
    }

}
