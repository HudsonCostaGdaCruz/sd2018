package parteDoisAtividade;

public class Consumidor extends Thread{
	
	Deposito dep;
	int i;
	
	public Consumidor (Deposito dep, int i){
		this.dep = dep;
		this.i = i;
	}
	
	public void run() {
		for (int j=1; j<=20;j++) {
		
			while (!dep.retirar()) {
				
			try {
				Thread.currentThread();
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}				
		}
		System.out.println("Consumido: " + dep.getNumItens());
	}
}