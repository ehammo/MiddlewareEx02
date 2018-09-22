package infraEstrutura.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import servicos.Estoque;

public class ServerUdp {
    public static void main(String[] args) throws IOException {
		int port = 2004;
        
        String out;
        @SuppressWarnings("resource")
		DatagramSocket  serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
        Estoque estoque = new Estoque();
    	while (true){
    		DatagramPacket receivePacket = new DatagramPacket(receiveData,
					receiveData.length);
    		serverSocket.receive(receivePacket);
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
        	InetAddress IPAddress = receivePacket.getAddress();
			int portReceive = receivePacket.getPort();
        	DatagramPacket sendPacket = new DatagramPacket(sendData,
					sendData.length, IPAddress, portReceive);
			serverSocket.send(sendPacket);
        	System.out.println("Data sent.");
        }
    }
}
   
