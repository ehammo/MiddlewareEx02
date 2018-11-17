package distribuicao;

import java.util.Arrays;

import distribuicao.criptografia.Cripto;
import distribuicao.criptografia.ICripto;
import distribuicao.criptografia.Marshaller;
import distribuicao.message.Message;
import infraEstrutura.IRequestHandler;
import infraEstrutura.tcp.TcpClientRequestHandler;

public class Requestor {
	public Termination invoke(Invocation inv) throws Exception{
		IRequestHandler crh = new TcpClientRequestHandler(inv.getHost(), inv.getPort());
		crh.create();
		
		Marshaller marshaller = new Marshaller();
		ICripto cripto = new Cripto();
		
		Termination termination = new Termination(null);
		Message msgToBeMarshalled = new Message(0, inv.getOperation(), inv.getParameters(), null);
		System.out.println("send msg: "+msgToBeMarshalled.toString());
		byte[] msgToBeCripted = marshaller.marshall(msgToBeMarshalled);
		System.out.println("marshalled");
		byte[] cripted = cripto.encript(msgToBeCripted);
		System.out.println("cripted");
		crh.send(cripted);
		System.out.println("sent: "+Arrays.toString(cripted));
		byte[] response = crh.receive();
		System.out.println("received");

		termination.setResult(marshaller.unmarshall(response));
		crh.closeConnection();
		return termination;
	}
}
