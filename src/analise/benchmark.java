package analise;

import java.io.IOException;

import tcp.ServerTcp;

public class benchmark {
	
	public static void main(String[] args) {
		
		ServerTcp server = new ServerTcp();
		try {
			server.main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
