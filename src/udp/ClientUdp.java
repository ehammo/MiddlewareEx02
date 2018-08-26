package udp;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUdp {
	
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 2004;
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
						sendData.length, IPAddress, port);
				socket.send(sendPacket);
				System.out.println("Message sent. Waiting for server response.");
				DatagramPacket receivePacket = new DatagramPacket(receiveData,
						receiveData.length);
				socket.receive(receivePacket);
				
				System.out.println(new String(receivePacket.getData()));
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Connection Failed");
		}
	}
}
