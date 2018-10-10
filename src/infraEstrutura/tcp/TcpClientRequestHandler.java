package infraEstrutura.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import infraEstrutura.IRequestHandler;

public class TcpClientRequestHandler implements IRequestHandler {

	private Socket socket;
	private DataOutputStream socketOut;
	private BufferedReader socketIn;
	
	public TcpClientRequestHandler(String host, int port) throws Exception{
		socket = new Socket(host,port);
		socketOut = new DataOutputStream(
				socket.getOutputStream());
		socketIn = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
	}
	
	@Override
	public void send(byte[] data) throws Exception {
		System.out.println("write");
		socketOut.write(data);
		System.out.println("wrote");
	}

	@Override
	public byte[] receive() throws Exception {
		System.out.println("trying to receive client");
		byte[] buffer = new byte[100*1024];
		socket.getInputStream().read(buffer);
		System.out.println("read");
		return buffer;
	}
	
	

}
