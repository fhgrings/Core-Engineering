public class LED implements Lampada {

    private boolean ligada;

    public LED() {
        off();
    }

    public void on() { ligada = true; }

    public void off() { ligada = false; }

    public boolean isOn() { return ligada; }

}
