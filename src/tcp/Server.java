package tcp;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) throws IOException {
         
        int portNumber = 2004;
        
        String in,out;
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        Estoque estoque = new Estoque();
        while (true){
        	Socket sock = welcomeSocket.accept();
        	System.out.println("Accepted.");
        	
        	BufferedReader socketIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        	System.out.println("Data received.");
        	while (!socketIn.ready());
        	String[] command = socketIn.readLine().split(" ");
        	if (command[0].equals("add")) {
        		estoque.add(command[1]);
        		out = "Added with Sucess\n";
        	} else if(command[0].equals("remove")){
        		estoque.remove(command[1]);
        		out = "Removed with Sucess\n";
        	} else if(command[0].equals("list")){
        		out = estoque.getAll()+"n";
        	} else {
        		out = "Invalid command. Use 'add', 'remove' or 'list' \n";
        	}
        	
        	DataOutputStream socketOut = new DataOutputStream(sock.getOutputStream());
        	socketOut.writeBytes(out);
        	System.out.println("Data sent.");
        	sock.close();
        }
    }
}
   
