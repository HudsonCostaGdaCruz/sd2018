import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ControleRemoto {
	
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		Socket clienteC = new Socket("127.0.0.1", 5555);
		System.out.println("Controle remoto conectado ao gateway");
		
		InputStream entrada = clienteC.getInputStream();//entrada de dados
		OutputStream saida = clienteC.getOutputStream();//saida de dados
		
		BufferedReader in = new BufferedReader(new InputStreamReader(entrada));
		PrintStream out = new PrintStream(saida);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Informe o aparelho que deseja ligar:");
			String mensagem = scanner.nextLine();
			//Envia para o Gateway
			out.println(mensagem);
						
			//Recebe do gateway
			mensagem = in.readLine();
			
			if (mensagem.equals("ARCON ligado")) {
				System.out.println("Informe a temperatura desejada: ");
				int temper = scanner.nextInt();
				//Envia para o Gateway
				out.println(temper);
			}
			
			if (mensagem.equals("TV ligada")) {
				System.out.println("Informe o canal desejado: ");
				int canal = scanner.nextInt();
				//Envia para o Gateway
				out.println(canal);
			}
			
			if ("FIM".equals(mensagem)) {
				break;
			}
		}
		
		System.out.println("Encerrando conexao.");
		
		in.close();
		
		out.close();
		
		clienteC.close();
	}
}
