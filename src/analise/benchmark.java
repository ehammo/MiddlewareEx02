package analise;

import java.io.IOException;

<<<<<<< HEAD
=======
import tcp.ClientTcp;
>>>>>>> 2ba1b6ce477b3b1a3076c7f163860f87f7a9f3b4
import tcp.ServerTcp;

public class benchmark {
	
	public static void main(String[] args) {
		
		ServerTcp server = new ServerTcp();
		try {
			server.main(null);
<<<<<<< HEAD
=======
			int numberExecutions = 1000;
			ClientTcp client = new ClientTcp("127.0.0.1", 2004);
			for(int i = 0; i < numberExecutions; i++) {
				
			}
>>>>>>> 2ba1b6ce477b3b1a3076c7f163860f87f7a9f3b4
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
