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
		System.out.println("send msg: "+msgToBeMarshalled.toString());
		crh.send(marshaller.marshall(msgToBeMarshalled));
		System.out.println("sent");
		termination.setResult(marshaller.unmarshall(crh.receive()));
		crh.closeConnection();
		return termination;
	}
}
