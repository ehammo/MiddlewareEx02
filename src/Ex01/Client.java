package Ex01;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		String host = "127.0.0.1";
		int port = 2004;
		try {
			Socket socket = new Socket(host,port);
			while(true) {
				Scanner scan = new Scanner(System.in);
				String in = scan.nextLine();
					
				DataOutputStream socketOut = new DataOutputStream(
													socket.getOutputStream());
				socketOut.writeBytes(in);
				System.out.println("Message sent. Waiting for server response.");
				BufferedReader socketIn = new BufferedReader(new InputStreamReader(
											socket.getInputStream()));
				System.out.println(socketIn.readLine());	    
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Connection Failed");
		}
	}
}
