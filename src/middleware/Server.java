package middleware;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	private Estoque estoque;
	
	public Server(String host, int port) throws RemoteException, MalformedURLException {
		estoque = new Estoque();
		System.out.println("rmi:"+host);
		LocateRegistry.createRegistry(port);
		Naming.rebind("rmi:"+host, estoque);
	}

	public String add(String item) throws RemoteException {
		return estoque.add(item);
	}

	public String remove(String item) throws RemoteException {
		return estoque.remove(item);
	}

	public String getAll() throws RemoteException {
		return estoque.getAll();
	}
	
	public static void main(String[] args)
			throws RemoteException, MalformedURLException  { 
        new Server(IEstoque.host, IEstoque.port); 
    } 

}
