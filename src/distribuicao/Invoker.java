package distribuicao;

import java.util.Arrays;

import distribuicao.criptografia.Cripto;
import distribuicao.criptografia.ICripto;
import distribuicao.criptografia.Marshaller;
import distribuicao.message.Message;
import infraEstrutura.Estoque;
import infraEstrutura.IRequestHandler;
import infraEstrutura.tcp.TcpServerRequestHandler;

public class Invoker {
	public void invoke(ClientProxy client) throws Exception {
		System.out.println("Running...");
		
		Marshaller marshaller = new Marshaller();
		ICripto cripto = new Cripto();
		
		Termination termination = new Termination(null);
		Estoque estoque = new Estoque();
		Message msgUncripted = null;
		IRequestHandler srh = new TcpServerRequestHandler(client.getPort());

		while(true) {
			srh.create();
			System.out.println("Running loop...");
			byte[] msgToBeUncripted = srh.receive();
			System.out.println("received: "+Arrays.toString(msgToBeUncripted));
			byte[] msgToBeUnmarshalled = cripto.decript(msgToBeUncripted);
			System.out.println("uncripted");
			msgUncripted = (Message) marshaller.unmarshall(msgToBeUnmarshalled);
			System.out.println("unmarshalled");
			switch(msgUncripted.getOperation()) {
			case "add":
				String item = (String) msgUncripted.getParameters().get(0);
				
				String result = estoque.add(item);
				termination.setResult(result);
				Message reply = new Message(0, null, null, termination.getResult());
				srh.send(marshaller.marshall(reply));
				System.out.println("sent response");
				break;
			}
			srh.closeConnection();
		}
	}
}
