package infraEstrutura.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import infraEstrutura.IRequestHandler;

public class TcpServerRequestHandler implements IRequestHandler {

	BufferedReader socketIn;
	DataOutputStream socketOut;
	Socket socket;
	public TcpServerRequestHandler(int port) throws Exception{
		ServerSocket welcomeSocket = new ServerSocket(port);
		socket = welcomeSocket.accept();
    	System.out.println("Accepted.");
    	socketIn = new BufferedReader(new InputStreamReader(
    			socket.getInputStream()));
    	socketOut = new DataOutputStream(socket.getOutputStream());
	}

	@Override
	public void send(byte[] data) throws Exception {
		socketOut.write(data);
	}

	@Override
	public byte[] receive() throws Exception {
		System.out.println("trying to receive");
		while (!socketIn.ready());
		System.out.println("ready");
		byte[] buffer = new byte[100*1024];
		socket.getInputStream().read(buffer);
		System.out.println("read");
		return buffer;
	}
	
	public String[] receiveAsStringArray() throws Exception{
		byte[] data = receive();
		String fullCommand = new String(data);
		return fullCommand.split(" ");
	}

}
