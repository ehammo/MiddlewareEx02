package infraEstrutura.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import distribuicao.IRequestHandler;

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
		socketOut.write(data);
	}

	@Override
	public byte[] receive() throws Exception {
		return socketIn.readLine().getBytes();
	}
	
	

}
