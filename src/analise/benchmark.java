package analise;

import java.io.IOException;
import tcp.ClientTcp;
import tcp.ServerTcp;

public class benchmark {
	
	public static void main(String[] args) {
		
		ServerTcp server = new ServerTcp();
		try {
			server.main(null);
			int numberExecutions = 1000;
			ClientTcp client = new ClientTcp("127.0.0.1", 2004);
			for(int i = 0; i < numberExecutions; i++) {
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}