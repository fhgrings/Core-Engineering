public class Incandescente implements Lampada {

    private boolean ligada;
    private boolean quente;

    public Incandescente() {
        off();
    }

    public void on() { quente = ligada = true; }

    public void off() { quente = ligada = false; }

    public boolean isOn() { return ligada; }
}
