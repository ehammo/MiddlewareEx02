package tcp;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTcp {
	
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
		//System.out.println("Message sent. Waiting for server response.");
		//System.out.println(socketIn.readLine());
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
