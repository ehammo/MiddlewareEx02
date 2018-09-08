package middleware;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
	
	private IEstoque server;
	
	public Client(String host) throws
						MalformedURLException,
						RemoteException,
						NotBoundException {
		server = (IEstoque) Naming.lookup(host);
	}
	
	
	public void add(String item) throws RemoteException {
		String message = server.add(item);
		System.out.println("Response = "+message);
		
	}
	
	public void remove(String item) throws RemoteException {
		String message = server.remove(item);
		System.out.println("Response = "+message);
	}
	
	public void getAll() throws RemoteException {
		String message = server.getAll();
		System.out.println("Response = "+message);
	}
	
	public static void main(String[] args)
			throws RemoteException, MalformedURLException, NotBoundException  { 
        Client client = new Client(IEstoque.host); 
    	while(true) {
    		Scanner in = new Scanner(System.in);
    		String fullLine = in.nextLine();
    		String[] command = fullLine.split(" ");
    		if (command[0].equals("add")) {
        		client.add(command[1]);
        	} else if(command[0].equals("remove")){
        		client.remove(command[1]);
        	} else if(command[0].equals("list")){
        		client.getAll();
        	} else {
        		System.out.println(
        				"Invalid command. Use 'add', 'remove' or 'list' \n");
        	}
    	}
    } 
	
}
