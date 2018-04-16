package objetos;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Lampada {
	
	private int intensidade;
	private int estado;
	private static Socket cliente;
	private static Lampada lamp;

	public Lampada(int Power, int Level){
		this.estado = Power;
		this.intensidade = Level;
	}

	public int setLigar(int s){
		if (s <=0)
			return 0;
		else
			this.estado = s;
			return 1;
	}

	public int setIntensidade(int l){
		if (l >= 0)
			return this.intensidade += l;
		else
			return 0;
	}

	public int getLigada(){
		return this.estado;
	}

	public int getIntensidade(){
		return this.intensidade;
	}
	
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		cliente = new Socket("127.0.0.1", 8888);
        System.out.println("Lampada conectada ao servidor!");
        lamp = new Lampada(1,10);
        
        System.out.print("Estado:");
        if (lamp.getLigada()==1)
        	System.out.println("Ligada!");
        System.out.println("Intensidade:" + lamp.getIntensidade());
 		
	}

}
