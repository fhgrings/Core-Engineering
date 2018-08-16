import java.util.Random;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            try{
                for(int i = 0; i < 50; i++)
                {
                    Thread.sleep(100);
                    System.out.println("numero par= "+ geraRandomPar());
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable task2 = () -> {
            try{
                for(int j = 0; j < 10; j++)
                {
                    Thread.sleep(500);
                    System.out.println("numer impar = " + geraRandomImpar());
                }
            }catch(InterruptedException f){
                f.printStackTrace();
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
    public static int geraRandomPar(){
        Random random = new Random();
        int n = random.nextInt(50);
        n = n*2;
        return n;
    }

    public static int geraRandomImpar(){
        Random random = new Random();
        int n = random.nextInt(50);
        n = n*2;
        n++;
        return n;
    }

}

