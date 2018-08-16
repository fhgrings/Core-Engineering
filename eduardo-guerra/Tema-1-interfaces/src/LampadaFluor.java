public class LampadaFluor implements Lampada {

    private String type = "Fluorescente";
    private boolean turnedOn = false;
    private int power;


    public LampadaFluor(int power){
        this.power = power;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
