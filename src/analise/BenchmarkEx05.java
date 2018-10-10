package analise;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import aplicacao.AppClient;
import infraEstrutura.IClient;
import infraEstrutura.middleware.Client;
import infraEstrutura.tcp.ClientTcp;
import infraEstrutura.udp.ClientUdp;

public class BenchmarkEx05 {
		
		public static void test(BufferedWriter writer, IClient client) throws Exception {
			int[] executionAmount = new int[] {50000};
			long start;
	        long end;
	        long duration;
	        for (int i = 0; i < executionAmount.length; i++) {
				for (int j = 0; j < executionAmount[i];j++) {
	                start = System.nanoTime();
	                client.add("new_item");
	                end = System.nanoTime();
	                duration = end - start;
	                if (duration > 0L) {
	                    writer.write(duration + "\n");
	                } else {
	                    j--; //so the counter doesn't move and we try again
	                }
				}
			}
		}
		
		public static void main(String[] args) {
			
	        
	        Path middleware_rmi = Paths.get("middleware_rmi.txt");
	        Path middleware_rcp = Paths.get("middleware_rcp.txt");

	        // we assume that both server applications are running on the side.
	        try {
//	            System.out.println("Middleware rcp test");
	            int port = 12345;
//	            BufferedWriter writer = Files.newBufferedWriter(middleware_rcp);
//	            AppClient appClient = new AppClient(); 
//	            test(writer, appClient);
//				System.out.println("Middleware rcp test ended");
				
	            System.out.println("Middleware rmi test");
	            BufferedWriter tcpWriter = Files.newBufferedWriter(middleware_rmi);
	    		String host = String.format("//127.0.0.1:%1$d/Estoque", port);
				Client clientRmi = new Client(host);
				test(tcpWriter, clientRmi);
	            System.out.println("Middleware rmi test ended");
	            
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	     
}
