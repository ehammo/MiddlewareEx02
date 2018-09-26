package distribuicao;

import infraEstrutura.middleware.Server;
import infraEstrutura.tcp.ServerTcp;
import infraEstrutura.udp.ServerUdp;

public class ServerFactory {
	
	private static final int MIDDLEWARE = 0;
	private static final int TCP = 1;
	private static final int UDP = 2;
	
	private String mHost;
	private int mPort;
	
	public ServerFactory(String host, int port){
		mHost = host;
		mPort = port;
	}
	
	public IServer getServer(int config) throws Exception{
		if (config == MIDDLEWARE) {
			return new Server(mHost, mPort);
		} else if (config == TCP) {
			return new ServerTcp(mPort);			
		} else if(config == UDP){
			return new ServerUdp(mPort);
		}
		return null;
	}
	
}
