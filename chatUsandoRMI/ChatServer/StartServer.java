import java.rmi.*;
import java.rmi.server.*;
 
public class StartServer {
	public static void main(String[] args) {
		try {
			 	java.rmi.registry.LocateRegistry.createRegistry(1099);
			 	
				ChatServerInt b=new ChatServer();	
				Naming.rebind("rmi://127.0.0.1/meuchat", b);
				System.out.println("[Sistema] Servidor de chat está pronto!");
			}catch (Exception e) {
					System.out.println("Servidor de chat falhou: " + e);
			}
	}
}
