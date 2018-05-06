package parteDoisAtividade;

public class Produtor extends Thread{
	Deposito dep;
	int i;
	boolean flag;
	
	public Produtor(Deposito dep, int i) {
		this.dep = dep;
		this.i = i;
	}
	
	public void run() {
		for (int j=1; j<=100;j++) {
			flag = dep.colocar();
			Thread.currentThread();
			try {
				Thread.sleep(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Produzido: " + dep.getNumItens());
	}
}
