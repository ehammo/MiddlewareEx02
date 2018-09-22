package infraEstrutura.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

import distribuicao.IClient;

public class ClientUdp implements IClient  {
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

    public void list() throws IOException {
        sendInfo("list "+"\n");
    }

    public void custom(String command) throws IOException {
        sendInfo(command+"\n");
    }

    public static void main(String[] args) throws IOException {
    	ClientUdp client = new ClientUdp("127.0.0.1", 2004);
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
    	while(true) {
    		String command = in.nextLine();
    		client.custom(command);
    	}
    }
}
