package objetos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TV{
	private int canalAtual;


	public TV(int dial){
		this.canalAtual = dial;
		
	}

	public void setEstacao(int dial){
		this.canalAtual = dial;
	}
	
	public int getCanalAtual(){
		return this.canalAtual;
	}	
	
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		Socket cliente = new Socket("127.0.0.1", 8889);
        System.out.println("TV conectada ao servidor!");
        
        InputStream entrada = cliente.getInputStream();//entrada de dados
		OutputStream saida = cliente.getOutputStream();//saida de dados
		
		BufferedReader in = new BufferedReader(new InputStreamReader(entrada));
		PrintStream out = new PrintStream(saida);
		
		int canal = in.read();
		
		TV tv = new TV(canal);
		
		//Envia essa informacao para o Gateway
		out.println(tv.getCanalAtual());
		
	}
}