public class Main {

    public static void main(String args[]) {

        Lampada lampada;
        Abajur abajur;

        lampada = new Incandescente();
        abajur = new Abajur(lampada);

        print(abajur);

        abajur._switch();

        print(abajur);

        lampada = new LED();
        abajur = new Abajur(lampada);

        print(abajur);

        abajur._switch();

        print(abajur);

    }

    private static void print(Abajur abajur) {
        System.out.println("Abajur " + abajur.tipo() + " " + abajur.estado());
    }

}
