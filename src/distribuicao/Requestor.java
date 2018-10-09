package distribuicao;

import distribuicao.message.Message;
import infraEstrutura.IRequestHandler;
import infraEstrutura.tcp.TcpClientRequestHandler;

public class Requestor {
	public Termination invoke(Invocation inv) throws Exception{
		IRequestHandler crh = new TcpClientRequestHandler(inv.getHost(), inv.getPort());
		
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination(null);
		Message msgToBeMarshalled = new Message(0, inv.getOperation(), inv.getParameters(), null);
		
		crh.send(marshaller.marshall(msgToBeMarshalled));
		termination.setResult(marshaller.unmarshall(crh.receive()));
		
		return termination;
	}
}
