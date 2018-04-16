package aulaDeSD13042018;

public class Racer implements Runnable {
	
		private int r;
		
		public Racer(int r){
			this.r = r;
		}
		public static void main(String args[]) throws InterruptedException {
			/*for (int j=1; j<=10; j++) {				
			(new Thread(new Racer(j))).start();
			Thread.sleep(5*1000);
			}*/	
			
			Racer R1 = new Racer(1);
			Racer R2 = new Racer(2);
			Racer R3 = new Racer(3);
			Racer R4 = new Racer(4);
			Racer R5 = new Racer(5);
			Racer R6 = new Racer(6);
			Racer R7 = new Racer(7);
			Racer R8 = new Racer(8);
			Racer R9 = new Racer(9);
			Racer R10 = new Racer(10);
			
			Thread T1 = new Thread(R1);
			Thread T2 = new Thread(R2);
			Thread T3 = new Thread(R3);
			Thread T4 = new Thread(R4);
			Thread T5 = new Thread(R5);
			Thread T6 = new Thread(R6);
			Thread T7 = new Thread(R7);
			Thread T8 = new Thread(R8);
			Thread T9 = new Thread(R9);
			Thread T10 = new Thread(R10);
			
			T1.start();
			T2.start();
			T3.start();
			T4.start();
			T5.start();
			T6.start();
			T7.start();
			T8.start();
			T9.start();
			T10.start();
			
			T1.sleep(2 * 1000);
			T2.sleep(2 * 1000);
			T3.sleep(2 * 1000);
			T4.sleep(2 * 1000);
			T5.sleep(2 * 1000);
			T6.sleep(2 * 1000);
			T7.sleep(2 * 1000);
			T8.sleep(2 * 1000);
			T9.sleep(2 * 1000);
			T10.sleep(2 * 1000);
			
			
			
		}
		
		@Override
		public void run() {
			
			while (true) {
				System.out.println("Racer " + r + ": imprimindo.");
			}
		}
}
