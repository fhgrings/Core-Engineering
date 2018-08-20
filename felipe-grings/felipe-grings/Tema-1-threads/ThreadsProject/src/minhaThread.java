public class minhaThread extends Thread {

    //private String nome;
    private int tempo;
    private String tipo;


    public minhaThread(String tipo, int tempo) {
        //this.nome = nome;
        this.tempo = tempo;
        this.tipo = tipo;

        start();
    }

    public void run() {


        try {
            while (true) {
                if (tipo == "impar") {
                    int x=(int) (Math.random()*100);
                    x += (x%2==0?1:0);
                    System.out.println("Thread A #" + tipo + " " + x);
                } else {
                    int x=(int) (Math.random()*50);
                    x = (x*2);
                    System.out.println("Thread B #" + tipo + " " + x);
                }
                Thread.sleep(tempo);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
