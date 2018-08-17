public class Abajur {

    private Lampada lampada;

    public Abajur(Lampada lampada) {
        this.lampada = lampada;
    }

    public void _switch() {
        if(lampada.isOn())
            lampada.off();
        else
            lampada.on();
    }

    public String estado() {
        if(lampada.isOn())
            return "ligado";
        return "desligado";
    }

    public String tipo() {
        if(lampada instanceof LED)
            return "LED";
        else
            return "Incandescente";
    }

}
