package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClientUdp {
    int port;
    String host;
    DatagramSocket socket;
    InetAddress ipAddress;
    byte[] sendData = new byte[1024];
    byte[] receiveData = new byte[1024];

    public ClientUdp(String host, int port) {
        try {
            this.host = host;
            this.port = port;
            socket = new DatagramSocket();
            ipAddress = InetAddress.getByName(host);
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }
    }

    private void sendInfo(String item) throws IOException {
        sendData = item.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,
                sendData.length, ipAddress, port);
        socket.send(sendPacket);
        DatagramPacket receivePacket = new DatagramPacket(receiveData,
                receiveData.length);
        socket.receive(receivePacket);
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

	/*public static void main(String[] args) {

        int port = 2004;
        String host = "127.0.0.1";
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
	}*/
}
