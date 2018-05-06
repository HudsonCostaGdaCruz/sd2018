package aulaDeSD13042018;

public class racerThread extends Thread{
	
	private int i;
	
	public racerThread(int r){
		super();
		this.i = r;
	}
	
	public void run(){
		int p = 1;
		while(p <=1000) {
		System.out.println("Racer " + this.i + " - imprimindo.");
		p++;
		}
	}
}