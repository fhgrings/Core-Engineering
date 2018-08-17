public class LED  implements Lampada {

    private boolean ligado;
    //private boolean off;

    @Override
    public void on(){
        ligado = true;
    }

    @Override
    public void off() {
        ligado = false;
    }

    @Override
    public boolean verificacao() {
        return ligado;
    }


}
