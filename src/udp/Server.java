package udp;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) throws IOException {
         
    	int portSend = 2005;
		int portReceive = 2004;
        
        String in,out;
        DatagramSocket  serverSocket = new DatagramSocket();
        byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
        Estoque estoque = new Estoque();
    	while (true){
    		DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length, portReceive);
    		serverSocket.receive(receivePacket);
    		InetAddress IPAddress = receivePacket.getAddress();
    		String[] command = new String(receivePacket.getData()).split(" ");
        	System.out.println("Data received.");
        	if (command[0].equals("add")) {
        		estoque.add(command[1]);
        		out = "Added with Sucess\n";
        	} else if(command[0].equals("remove")){
        		estoque.remove(command[1]);
        		out = "Removed with Sucess\n";
        	} else if(command[0].equals("list")){
        		out = estoque.getAll()+"\n";
        	} else {
        		out = "Invalid command. Use 'add', 'remove' or 'list' \n";
        	}
        	sendData = out.getBytes();
        	DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, portSend);
			serverSocket.send(sendPacket);
        	System.out.println("Data sent.");
        }
//    	sock.close();
    }
}
   
