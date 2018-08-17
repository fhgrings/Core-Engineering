package models;

import java.util.Random;

public class OddThread extends Thread {

    OddThread() {
        System.out.println("OddThread initialized");
        start();
    }

    public void run(){
        for (int i=0; i<10; i++) {
            try {
                System.out.println("odd: " + randomOddNumber(1, 500));
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static int randomOddNumber(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).limit(1).map(n -> n * 2 + 1).findFirst().getAsInt();
    }
}
