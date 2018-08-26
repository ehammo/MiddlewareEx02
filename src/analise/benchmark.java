package analise;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import tcp.ClientTcp;
import tcp.ServerTcp;
import udp.ClientUdp;

public class benchmark {
	
	public static void main(String[] args) {
		
		ServerTcp server = new ServerTcp();
		int[] executionAmount = new int[] {100, 1000, 5000, 10000, 50000};
        Instant start;
        Instant end;
        System.out.println("TCP test");
        // we assume that the server application is running on the side.
        try {
			ClientTcp client = new ClientTcp("127.0.0.1", 2005);
			System.out.println("TCP test");
			for (int i = 0; i < executionAmount.length; i++) {
			    start = Instant.now();
				for (int j = 0; j < executionAmount[i]; j++) {
					client.add("new_item");
				}
				end = Instant.now();
                System.out.println(executionAmount[i] + " requests took " + Duration.between(start, end).toMillis());
			}
			System.out.println("TCP test ended");

            ClientUdp udpClient = new ClientUdp("127.0.0.1",2004);
            System.out.println("Udp test");
            for (int i = 0; i < executionAmount.length; i++) {
                start = Instant.now();
                for (int j = 0; j < executionAmount[i]; j++) {
                    udpClient.add("new_item");
                }
                end = Instant.now();
                System.out.println(executionAmount[i] + " requests took " + Duration.between(start, end).toMillis());
            }
            System.out.println("TCP test ended");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}