package infraEstrutura.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import distribuicao.IRequestHandler;

public class TcpServerRequestHandler implements IRequestHandler {

	BufferedReader socketIn;
	DataOutputStream socketOut;
	
	public TcpServerRequestHandler(int port) throws Exception{
		ServerSocket welcomeSocket = new ServerSocket(port);
		Socket sock = welcomeSocket.accept();
    	System.out.println("Accepted.");
    	socketIn = new BufferedReader(new InputStreamReader(
				sock.getInputStream()));
    	socketOut = new DataOutputStream(sock.getOutputStream());
	}

	@Override
	public void send(byte[] data) throws Exception {
		socketOut.write(data);
	}

	@Override
	public byte[] receive() throws Exception {
		while (!socketIn.ready());
		return socketIn.readLine().getBytes();
	}
	
	public String[] receiveAsStringArray() throws Exception{
		byte[] data = receive();
		String fullCommand = new String(data);
		return fullCommand.split(" ");
	}

}
