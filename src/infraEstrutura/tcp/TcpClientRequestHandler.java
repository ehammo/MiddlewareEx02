package infraEstrutura.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import infraEstrutura.IRequestHandler;

public class TcpClientRequestHandler implements IRequestHandler {

	private Socket socket;
	private DataOutputStream socketOut;
	private BufferedReader socketIn;
	
	public TcpClientRequestHandler(String host, int port) throws Exception{
		socket = new Socket(host,port);
	}

	public void create() throws IOException {
		socketOut = new DataOutputStream(
				socket.getOutputStream());
		socketIn = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));

	}
	
	@Override
	public void send(byte[] data) throws Exception {
		while(!socket.isClosed())
		socketOut.write(data);
	}

	@Override
	public byte[] receive() throws Exception {
		System.out.println("trying to receive client");
		byte[] buffer = new byte[100*1024];
		socket.getInputStream().read(buffer);
		System.out.println("read");
		return buffer;
	}
	
	public void closeConnection() throws IOException{
		System.out.println("cliente fechou");
		socket.close();
		socketIn.close();
		socketOut.close();
	}


}
