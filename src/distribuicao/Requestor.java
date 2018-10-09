package distribuicao;

import infraEstrutura.IRequestHandler;

public class Requestor {
	IRequestHandler client;
	
	public Requestor(IRequestHandler client){
		this.client = client;
	}

	public Object invoke(Invocation inv){
		return null;
	}
}
