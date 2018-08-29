package analise;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import tcp.ClientTcp;
import tcp.ServerTcp;
import udp.ClientUdp;

public class benchmark {
	
	public static void main(String[] args) {
		
		ServerTcp server = new ServerTcp();
		int[] executionAmount = new int[] {50000};
		ArrayList<Long> results = new ArrayList<>();
        Instant start;
        Instant end;
        System.out.println("TCP test");
        Path tcpPath = Paths.get("tcp.txt");
        Path udpPath = Paths.get("udp.txt");
        // we assume that both server applications are running on the side.
        try {
            BufferedWriter tcpWriter = Files.newBufferedWriter(tcpPath);
			ClientTcp client = new ClientTcp("127.0.0.1", 2005);
			System.out.println("TCP test");
			for (int i = 0; i < executionAmount.length; i++) {
				for (int j = 0; j < executionAmount[i]; j++) {
                    start = Instant.now();
                    client.add("new_item");
                    end = Instant.now();
                    tcpWriter.write(String.valueOf(Duration.between(start, end).toMillis()) + "\n");
                    //results.add(Duration.between(start, end).toMillis());
				}

                //System.out.println(executionAmouznt[i] + " requests took " + Duration.between(start, end).toMillis());
			}
			System.out.println("TCP test ended");

			BufferedWriter udpWriter = Files.newBufferedWriter(udpPath);
            ClientUdp udpClient = new ClientUdp("127.0.0.1",2004);
            System.out.println("Udp test");
            for (int i = 0; i < executionAmount.length; i++) {
                for (int j = 0; j < executionAmount[i]; j++) {
                    start = Instant.now();
                    udpClient.add("new_item");
                    end = Instant.now();
                    udpWriter.write(String.valueOf(Duration.between(start, end).toMillis()) + "\n");
                }

                //System.out.println(executionAmount[i] + " requests took " + Duration.between(start, end).toMillis());
            }
            System.out.println("UDP test ended");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}