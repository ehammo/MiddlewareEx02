package distribuicao;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import infraEstrutura.middleware.Server;

public class EstoqueDistribution {

	private ClientFactory mClientFactory;
	private ServerFactory mServerFactory;
	private int mConfig;
	
	private IServer server;
	private IClient client;
	
	public EstoqueDistribution(String host, int port, int config){
		mClientFactory = new ClientFactory(host, port);
		mServerFactory = new ServerFactory(host, port);
		mConfig = config;
		startService();
	}
	
	public void startService() {
		try {
			new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						System.out.println("gonna get the server");
						server = mServerFactory.getServer(mConfig);
						System.out.println("got the server");
						
						System.out.println("gonna get the client");
						client = mClientFactory.getClient(mConfig);		
						System.out.println("got the client");
						
						System.out.println("gonna start the server");
						server.start();
						System.out.println("started");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void add(String item) throws Exception{
		while(client == null || server == null){}
		client.add(item);
	}
	
	public static void main(String[] args) throws Exception {
//		EstoqueDistribution estoqueDistribution = new EstoqueDistribution("127.0.0.1", 12345, 0);
		EstoqueDistribution estoqueDistribution2 = new EstoqueDistribution("127.0.0.1", 2005, 1);
//		EstoqueDistribution estoqueDistribution3 = new EstoqueDistribution("127.0.0.1", 2006, 2);
		
//		System.out.println("middle");
		
//		estoqueDistribution.add("oi");
//		estoqueDistribution.add("oi");
//		estoqueDistribution.add("oi");
//		
		System.out.println("tcp");
			
		estoqueDistribution2.add("oi");
//		estoqueDistribution2.add("oi");
//		estoqueDistribution2.add("oi");
//		
//		System.out.println("udp");
//		
//		estoqueDistribution3.add("oi");
//		estoqueDistribution3.add("oi");
//		estoqueDistribution3.add("oi");
		
		
	}
	
}
