package udp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int portSend = 2004;
		int portReceive = 2005;
		try {
			DatagramSocket socket = new DatagramSocket();
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			InetAddress IPAddress = InetAddress.getByName(host);
			
			while(true) {
				Scanner scan = new Scanner(System.in);
				String in = scan.nextLine()+"\n";
				sendData = in.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,
						sendData.length, IPAddress, portSend);
				socket.send(sendPacket);
				System.out.println("Message sent. Waiting for server response.");
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length, IPAddress, portReceive);
				socket.receive(receivePacket);
				
				System.out.println(new String(receivePacket.getData()));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Connection Failed");
		}
	}
}
