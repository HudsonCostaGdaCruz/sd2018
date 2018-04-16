package objetos;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Geladeira{
	private float temperatura;
	private int estado;

	public Geladeira(int est, float temp){
		this.estado = est;
		this.temperatura = temp;
		
	}

	public void setTemperatura(float temp){
		this.temperatura += temp;
	}


	public int setLigar(int s){
		if (s <=0)
			return 0;
		else
			this.estado = s;
			return 1;
	}

	public float getTemperatura(){
		return this.temperatura;
	}	
	
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		Socket clienteG = new Socket("127.0.0.1", 8891);
        System.out.println("Geladeira conectada ao servidor!");
		
	}
}