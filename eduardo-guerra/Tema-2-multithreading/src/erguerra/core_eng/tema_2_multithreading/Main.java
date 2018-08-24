package erguerra.core_eng.tema_2_multithreading;

import java.util.Random;
import java.lang.Thread;


public class Main {
    public static void main(String[] args) {
        Runnable task1 = () -> {
            try{
                for(int i = 0; i < 50; i++)
                {
                    Thread.sleep(100);
                    System.out.println("numero par = "+ gerarNumeroPar());
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
                    System.out.println("numero impar = " + gerarNumeroImpar());
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
    public static int gerarNumeroPar(){
        Random random = new Random();
        int numero = random.nextInt(50);
        return numero*2;
    }
    public static int gerarNumeroImpar(){
        Random random = new Random();
        int numero = random.nextInt(50);
        return (numero*2)+1;
    }
}
