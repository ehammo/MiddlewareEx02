package tcp;

import java.io.IOException;
import java.util.Scanner;

public class ClientConnectionTcp {
    public static void main(String[] args) throws IOException {
    	ClientTcp client = new ClientTcp("127.0.0.1", 2004);
    	while(true) {
    		Scanner in = new Scanner(System.in);
    		String command = in.nextLine();
    		client.custom(command);
    	}
    
    
    }
}
