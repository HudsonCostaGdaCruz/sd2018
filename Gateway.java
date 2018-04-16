import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Gateway {
	
	private static ServerSocket servLamp;
	private static ServerSocket servTV;
	private static ServerSocket servArCon;
	private static ServerSocket servGela;
	private static ServerSocket servRadio;
	private static ServerSocket servControle;
	
	private static Socket clienteLamp;
	private static Socket clienteTV;
	private static Socket clienteArCon;
	private static Socket clienteGela;
	private static Socket clienteRadio;
	private static Socket clienteControle;
	private static boolean arconligado;
	private static boolean tvligada;
	private static boolean lampligadas;
	private static boolean radioligado;
	private static boolean gelaligada;
			
	public static void escutaEaguarda(String objeto) throws IOException{
		
		switch (objeto){					
		case "LAMPADAS":
			servLamp = new ServerSocket(8888);
	        System.out.println("Aguardando conexao do cliente de lâmpadas!");
	        clienteLamp = servLamp.accept();
	        System.out.println("Lampadas conectadas!");
	        lampligadas = true;
	        break;
	        
		case "TV":
			servTV = new ServerSocket(8889);
	        System.out.println("Aguardando conexao do cliente de TV!");
	        clienteTV = servTV.accept();
	        System.out.println("TV conectada!");
	        tvligada = true;
	        break;
	        
		case "ARCON":
			servArCon = new ServerSocket(8890);
	        System.out.println("Aguardando conexao do cliente de ar condicinado!");
	        clienteArCon = servArCon.accept();
	        System.out.println("Ar condicionado conectado!");
	        arconligado = true;
	        break;
			
		case "GELA":
			servGela = new ServerSocket(8891);
	        System.out.println("Aguardando conexao do cliente de geladeira!");
	        clienteGela = servGela.accept();
	        System.out.println("Geladeira conectada!");
	        gelaligada = true;
	        break;
	        
		case "RADIO":
			servRadio = new ServerSocket(8892);
	        System.out.println("Aguardando conexao do cliente de radio!");
	        clienteRadio = servRadio.accept();
	        System.out.println("Radio conectado!");
	        radioligado = true;
	        break;
		}
	}

public static void main (String[] args) throws IOException {
    	
    try {	
    	//Conexão do controle remoto
    	servControle = new ServerSocket(5555);
        System.out.println("Aguardando conexao do controle remoto!");
        clienteControle = servControle.accept();
    	System.out.println("Controle remoto conectado!");
    	
    	//Canais de entrada e saida entre o gateway e o cliente controle remoto
    	InputStream entrada = clienteControle.getInputStream();
    	OutputStream saida = clienteControle.getOutputStream();
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(entrada));
    	PrintStream out = new PrintStream(saida);
    	
    	
    	
    	while (true) {
    		
    		//Recebido do cliente controle
    		String mensagem = in.readLine();

    		//metodo que intancia os SocketServers
    		escutaEaguarda(mensagem);
    		    		
    		System.out.println("Aparelho ligado: " + mensagem);
    		
    		if (arconligado) {
    			//Canais de entrada e saida entre o gateway e o cliente ar condicionado
    	    	InputStream entradaArCon = clienteArCon.getInputStream();
    	    	OutputStream saidaArCon = clienteArCon.getOutputStream();
    	    	
    	    	BufferedReader inAC = new BufferedReader(new InputStreamReader(entradaArCon));
    	    	PrintStream outAC = new PrintStream(saidaArCon);
    	    	
        		//Envia para o cliente controle
        		out.println("ARCON ligado");
        		
        		int temper = in.read();
        		//envia para o cliente ArCon
    	    	outAC.println(temper);
    	    	temper = in.read();
    	    	System.out.println("Nova temperatura: " + temper);
    	    
    	    	arconligado = false;
    		}
    		
    		if (tvligada) {
    			//Canais de entrada e saida entre o gateway e o cliente ar condicionado
    	    	InputStream entradaTV = clienteTV.getInputStream();
    	    	OutputStream saidaTV = clienteTV.getOutputStream();
    	    	
    	    	BufferedReader inTV = new BufferedReader(new InputStreamReader(entradaTV));
    	    	PrintStream outTV = new PrintStream(saidaTV);
    	    	
        		//Envia para o cliente controle
        		out.println("TV ligada");
        		
        		int canal = in.read();
        		//envia para o cliente TV
    	    	outTV.println(canal);
    	    	canal = in.read();
    	    	System.out.println("Novo canal: " + canal);
    	    
    	    	tvligada = false;
    		}
    		
    		
    		if ("FIM".equals(mensagem)) {
    			break;
    		}

    	}
    	
    	System.out.println("Encerrando...");
    	
    	in.close();
    	out.close();
    	clienteControle.close();
		} catch (IOException e){
			System.out.println("Erro no servidor: " + e.getMessage());
		}
	}
}
