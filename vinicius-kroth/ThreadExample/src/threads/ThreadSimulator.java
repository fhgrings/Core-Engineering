package threads;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadSimulator {

	public static void main(String[] args) {
		Runnable taskEvenNumbers = () -> {

			for (int i = 0; i < 50; i++) {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
					int number = ThreadLocalRandom.current().nextInt(50, 500);
					if (number % 2 != 0)
						number++;
					System.out.println("Even numbers thread : " + number);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			}
		};
		
		Runnable taskOddNumbers = () -> {

			for (int i = 0; i < 50; i++) {
				try {
					TimeUnit.MILLISECONDS.sleep(100);
					int number = ThreadLocalRandom.current().nextInt(50, 500);
					if (number % 2 == 0)
						number++;
					System.out.println("Odd numbers thread : " + number);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}

			}
		};
		


		Thread threadEvenNumbers = new Thread(taskEvenNumbers);
		threadEvenNumbers.start();

		Thread threadOddNumbers= new Thread(taskOddNumbers);
		threadOddNumbers.start();



	}

}
