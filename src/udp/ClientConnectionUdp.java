package udp;

import java.io.IOException;
import java.util.Scanner;

public class ClientConnectionUdp {
    public static void main(String[] args) throws IOException {
    	ClientUdp client = new ClientUdp("127.0.0.1", 2004);
    	while(true) {
    		Scanner in = new Scanner(System.in);
    		String command = in.nextLine();
    		client.custom(command);
    	}
    }
}
