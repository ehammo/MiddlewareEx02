package infraEstrutura.tcp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import distribuicao.IServer;
import servicos.Estoque;


public class ServerTcp extends IServer {
		
	static BufferedReader socketIn;
	static DataOutputStream socketOut;
	
	public ServerTcp() throws IOException{
		port = 2005;
		estoque = new Estoque();
		ServerSocket welcomeSocket = new ServerSocket(port);
		Socket sock = welcomeSocket.accept();
    	System.out.println("Accepted.");
    	socketIn = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
    	socketOut = new DataOutputStream(sock.getOutputStream());
    	
	}
	
    public static void main(String[] args) throws Exception {
    	String out;
    	ServerTcp server = new ServerTcp();
    	while (true){
    		while (!socketIn.ready());
        	String[] command = socketIn.readLine().split(" ");
        	if (command[0].equals("add")) {
        		out = server.add(command[1]);
        	} else if(command[0].equals("remove")){
        		out = server.remove(command[1]);
        	} else if(command[0].equals("list")){
        		out = server.getAll();
        	} else {
        		out = "Invalid command. Use 'add', 'remove' or 'list' \n";
        	}
        	socketOut.writeBytes(out);
        }
    }
}
   
