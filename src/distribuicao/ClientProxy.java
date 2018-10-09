package distribuicao;

import java.io.Serializable;

public class ClientProxy implements Serializable {
	private static final long serialVersionUID = 1L;
	String host;
	int port;
	int objectId;
	
	public ClientProxy(String host, int port, int objectId){
		this.host = host;
		this.port = port;
		this.objectId = objectId;
	}
}
