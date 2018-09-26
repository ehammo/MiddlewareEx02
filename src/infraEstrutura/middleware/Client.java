package infraEstrutura.middleware;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import distribuicao.IClient;
import infraEstrutura.IEstoque;

public class Client implements IClient {
	
	private IEstoque server;
	
	public Client(String host, int port) throws
						MalformedURLException,
						RemoteException,
						NotBoundException {
		host = String.format("//%1$s:%2$d/Estoque", host, port);
		System.out.println("host: '"+host+"'");
		server = (IEstoque) Naming.lookup(host);
	}
	
	
	public void add(String item) throws RemoteException {
		String message = server.add(item);
		System.out.println(message);
		
	}
	
	public void remove(String item) throws RemoteException {
		String message = server.remove(item);
		System.out.println(message);
	}
	
	public void list() throws RemoteException {
		String message = server.getAll();
		System.out.println(message);
	}
	
	public static void main(String[] args)
			throws RemoteException, MalformedURLException, NotBoundException  { 
		int port = 12345;
		Client client = new Client("127.0.0.1", port); 
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        while(true) {
    		String fullLine = in.nextLine();
    		String[] command = fullLine.split(" ");
    		if (command[0].equals("add")) {
        		client.add(command[1]);
        	} else if(command[0].equals("remove")){
        		client.remove(command[1]);
        	} else if(command[0].equals("list")){
        		client.list();
        	} else {
        		System.out.println(
        				"Invalid command. Use 'add', 'remove' or 'list' \n");
        	}
    	}
    } 
	
}
