import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
         
        int portNumber = 2004;
        
        String in,out;
        ServerSocket welcomeSocket = new ServerSocket(portNumber);
        
        while (true){
        	Socket sock = welcomeSocket.accept();
        	System.out.println("Accepted.");
        	
        	BufferedReader socketIn = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        	System.out.println("Data received.");
        	while (!socketIn.ready());
        	in = socketIn.readLine();
        	System.out.println(in);
        	out = in + "\n";
        	
        	DataOutputStream socketOut = new DataOutputStream(sock.getOutputStream());
        	socketOut.writeBytes(out);
        	System.out.println("Data sent.");
        	sock.close();
        }
    }
}
   
