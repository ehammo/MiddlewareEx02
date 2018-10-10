package distribuicao;

import distribuicao.message.Message;
import infraEstrutura.Estoque;
import infraEstrutura.IRequestHandler;
import infraEstrutura.tcp.TcpServerRequestHandler;

public class Invoker {
	public void invoke(ClientProxy client) throws Exception {
		System.out.println("Running...");
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination(null);
		Estoque estoque = new Estoque();
		Message msgUnmarshalled = null;
		
		while(true) {
			IRequestHandler srh = new TcpServerRequestHandler(client.getPort());
			System.out.println("Running loop...");
			byte[] msgToBeUnmarshalled = srh.receive();
			System.out.println("received");
			msgUnmarshalled = (Message) marshaller.unmarshall(msgToBeUnmarshalled);
			System.out.println("unmarshalled");
			switch(msgUnmarshalled.getOperation()) {
			case "add":
				String item = (String) msgUnmarshalled.getParameters().get(0);
				
				String result = estoque.add(item);
				termination.setResult(result);
				Message reply = new Message(0, null, null, termination.getResult());
				srh.send(marshaller.marshall(reply));
				break;
			}
		}
	}
}
