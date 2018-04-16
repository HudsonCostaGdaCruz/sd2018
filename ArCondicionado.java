package objetos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ArCondicionado{
	private int temperatura;

	public ArCondicionado(int temp){

		this.temperatura = temp;
		
	}

	public void setTemperatura(int temp){
		this.temperatura += temp;
	}

	public int getTemperatura(){
		return this.temperatura;
	}

	public static void main (String[] args) throws UnknownHostException, IOException {
		
		Socket cliente = new Socket("127.0.0.1", 8890);
        System.out.println("Ar condicionado conectado ao servidor!");
        
        InputStream entrada = cliente.getInputStream();//entrada de dados
		OutputStream saida = cliente.getOutputStream();//saida de dados
		
		BufferedReader in = new BufferedReader(new InputStreamReader(entrada));
		PrintStream out = new PrintStream(saida);
		
		int temp = in.read();
		
		ArCondicionado ArCon = new ArCondicionado(temp);
		
		//Envia essa informacao para o Gateway
		out.println(ArCon.getTemperatura());
		
	}
}