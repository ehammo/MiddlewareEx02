package udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientUdp {
	DatagramSocket socket;
	byte[] sendData;
	byte[] receiveData;
	InetAddress IPAddress;
	int port;
	
	public ClientUdp(String host, int port) throws SocketException, UnknownHostException{
		this.socket = new DatagramSocket();
		this.sendData = new byte[1024];
		this.receiveData = new byte[1024];
		this.IPAddress = InetAddress.getByName(host);
		this.port = port;
	}
	
	private void sendInfo(String in) throws IOException {
		this.sendData = in.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(this.sendData,
				this.sendData.length, this.IPAddress, this.port);
		this.socket.send(sendPacket);
		System.out.println("Message sent. Waiting for server response.");
		DatagramPacket receivePacket = new DatagramPacket(receiveData,
				receiveData.length);
		this.socket.receive(receivePacket);
		
		System.out.println(new String(receivePacket.getData()));
	}
	
	public void add(String item) throws IOException {
		sendInfo("add "+item+"\n");
	}
	
	public void remove(String item) throws IOException {
		sendInfo("remove "+item+"\n");
	}
	
	public void list(String item) throws IOException {
		sendInfo("list "+item+"\n");
	}
	
	public void custom(String command) throws IOException {
		sendInfo(command+"\n");
	}
}
