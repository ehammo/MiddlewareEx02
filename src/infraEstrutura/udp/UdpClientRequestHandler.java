package infraEstrutura.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import distribuicao.IRequestHandler;

public class UdpClientRequestHandler implements IRequestHandler {

	int port;
    String host;
    DatagramSocket socket;
    InetAddress ipAddress;
    byte[] receiveData = new byte[1024];
	
	public UdpClientRequestHandler(String host, int port){
		try {
            this.host = host;
            this.port = port;
            socket = new DatagramSocket();
            ipAddress = InetAddress.getByName(host);
        } catch (Exception e) {
            System.out.println("Connection Failed");
        }
	}
	
	@Override
	public void send(byte[] data) throws Exception {
		DatagramPacket sendPacket = new DatagramPacket(data,
                data.length, ipAddress, port);
        socket.send(sendPacket);
	}

	@Override
	public byte[] receive() throws Exception {
		DatagramPacket receivePacket = new DatagramPacket(receiveData,
                receiveData.length);
		socket.receive(receivePacket);
		return receivePacket.getData();
	}
	
	

}
