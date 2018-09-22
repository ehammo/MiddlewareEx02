package infraEstrutura.tcp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import distribuicao.IClient;

public class ClientTcp implements IClient {
	
	private Socket socket;
	private DataOutputStream socketOut;
	private BufferedReader socketIn;
	
	public ClientTcp(String host, int port) throws UnknownHostException, IOException{
		socket = new Socket(host,port);
		socketOut = new DataOutputStream(
				socket.getOutputStream());
		socketIn = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
	}
	
	private void sendInfo(String in) throws IOException {
		socketOut.writeBytes(in);
		System.out.println("Message sent. Waiting for server response.");
		System.out.println(socketIn.readLine());
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
    	ClientTcp client = new ClientTcp("127.0.0.1", 2005);
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
    	while(true) {
    		String command = in.nextLine();
    		client.custom(command);
    	}
    }

}
