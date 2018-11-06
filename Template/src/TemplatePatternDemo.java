public class TemplatePatternDemo {
    public static void main(String[] args) {
        MaquinaCafe maquinaCafe = new Cafe();
        maquinaCafe.prepararBebida();

        MaquinaCafe maquinaCafe1 = new Achocolatado();
        maquinaCafe1.prepararBebida();
    }
}
