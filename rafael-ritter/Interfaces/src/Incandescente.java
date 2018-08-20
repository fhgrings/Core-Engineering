public class Incandescente implements Lampada {

    private boolean ligada;

    public Incandescente() {
        off();
    }

    public void on() { ligada = true; }

    public void off() { ligada = false; }

    public boolean isOn() { return ligada; }
}
