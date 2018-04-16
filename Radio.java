package objetos;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class Radio implements Serializable{
	private float estacaoAtual;
	private int estado;

	public Radio(int est, float dial){
		this.estado = est;
		this.estacaoAtual = dial;
		
	}

	public void setEstacao(float dial){
		this.estacaoAtual = dial;
	}


	public int setLigar(int s){
		if (s <=0)
			return 0;
		else
			this.estado = s;
			return 1;
	}

	public float getEstacaoAtual(){
		return this.estacaoAtual;
	}
	
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		Socket cliente = new Socket("127.0.0.1", 8892);
        System.out.println("Radio conectado ao servidor!");
		
	}
}