package infraEstrutura.middleware;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import distribuicao.IServer;
import infraEstrutura.Estoque;

public class Server extends IServer {

	public Server(String host, int port) throws RemoteException, MalformedURLException {
		estoque = new Estoque();
		LocateRegistry.createRegistry(port);
		this.host = String.format("rmi://%1$s:%2$d/Estoque", host, port);
		System.out.println(this.host);
		Naming.rebind(this.host, estoque);
	}
	
	public void start(){
		// todo
	}

	public void stop() {
		// todo
	}

	
    public static void main(String[] args) throws
        RemoteException, MalformedURLException {
		int port = 12345;
		String host = String.format("//127.0.0.1:%1$d/Estoque", port);
    	new Server("127.0.0.1", port);
    }


}
