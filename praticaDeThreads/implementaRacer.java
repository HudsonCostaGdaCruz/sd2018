package aulaDeSD13042018;

public class implementaRacer {
	
	public static void main(String args[]) throws InterruptedException {
		
		for (int i=1; i<=10; i++) {
			if (i == 5)
				Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			
			new racerThread(i).start();
			
			Thread.currentThread().sleep(3000);
		}
	}

}