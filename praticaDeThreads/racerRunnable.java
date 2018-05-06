package aulaDeSD13042018;

public class racerRunnable implements Runnable{
	
	private int r;
	
	public racerRunnable(int i) {
		this.r = i;
	}
	
	public static void main(String args[]) {
		racerRunnable racerUm = new racerRunnable(1);
		Thread t1 = new Thread(racerUm);
		t1.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("Racer " + this.r + " - imprimindo.");
			}
		
	}
}