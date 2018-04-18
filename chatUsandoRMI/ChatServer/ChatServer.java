import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;


public class ChatServer  extends UnicastRemoteObject implements ChatServerInt{
	
	private Vector v=new Vector();	
	public ChatServer() throws RemoteException{}
		
	public boolean login(ChatClientInt a) throws RemoteException{	
		System.out.println(a.getName() + "  conectado...");	
		a.tell("Conexão bem sucedida!");
		publish(a.getName()+ " acabou de se conectar! :-)");
		v.add(a);
		return true;		
	}
	
	public void publish(String s) throws RemoteException{
	    System.out.println(s);
		for(int i=0;i<v.size();i++){
		    try{
		    	ChatClientInt tmp=(ChatClientInt)v.get(i);
				tmp.tell(s);
		    }catch(Exception e){
		    }
		}
	}

	public Vector getConnected() throws RemoteException{
		return v;
	}
}
