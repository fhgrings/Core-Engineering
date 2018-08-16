public class LampadaLed implements Lampada{
    private String type = "Led";
    private boolean turnedOn = false;
    private String color; //Um atributo que diferencie um objeto do outro para mostrar o funcionamento da interface
    public LampadaLed(String color){
        this.color = color;
    }
    public void on(){
        if(turnedOn)
            System.out.println("Lampada jah estah ligada");
        else{
            turnedOn = true;
            System.out.println("Lampada foi ligada");
        }
    }
    public void off(){
        if(!turnedOn)
            System.out.println("Lampada jah estah desligada");
        else{
            turnedOn = false;
            System.out.println("Lampada foi desligada");
        }
    }
    public boolean isTurnedOn() {
        return turnedOn;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}