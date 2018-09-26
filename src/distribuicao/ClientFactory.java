package distribuicao;

import infraEstrutura.middleware.Client;
import infraEstrutura.tcp.ClientTcp;
import infraEstrutura.udp.ClientUdp;

public class ClientFactory {
	
	private static final int MIDDLEWARE = 0;
	private static final int TCP = 1;
	private static final int UDP = 2;
	
	private String mHost;
	private int mPort;
	
	public ClientFactory(String host, int port){
		mHost = host;
		mPort = port;
	}
	
	public IClient getClient(int config) throws Exception{
		if (config == MIDDLEWARE) {
			return new Client(mHost, mPort);
		} else if (config == TCP) {
			return new ClientTcp(mHost, mPort);			
		} else if(config == UDP){
			return new ClientUdp(mHost, mPort);
		}
		return null;
	}
	
}
