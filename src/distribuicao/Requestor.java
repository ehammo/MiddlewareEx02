package distribuicao;

import infraEstrutura.IRequestHandler;

public class Requestor {
	private IRequestHandler client;

	public Requestor(IRequestHandler client){
		this.client = client;
	}

	public Object invoke(Invocation inv){
		return null;
	}
	
	public IRequestHandler getClient() {
		return client;
	}

	public void setClient(IRequestHandler client) {
		this.client = client;
	}
}
