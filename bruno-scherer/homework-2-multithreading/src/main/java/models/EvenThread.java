package models;

import java.util.Random;

public class EvenThread extends Thread {

    EvenThread() {
        System.out.println("EvenThread initialized");
        start();
    }

    public void run(){
        for (int i=0; i<10; i++) {
            try {
                System.out.println("even: " + randomEvenNumber(1, 500));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int randomEvenNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).limit(1).map(n -> n * 2).findFirst().getAsInt();
    }
}
