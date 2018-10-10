package distribuicao;

import distribuicao.message.Message;
import infraEstrutura.Estoque;
import infraEstrutura.IRequestHandler;
import infraEstrutura.tcp.TcpServerRequestHandler;

public class Invoker {
	public void invoke(ClientProxy client) throws Exception {
		System.out.println("Running...");
		IRequestHandler srh = new TcpServerRequestHandler(client.getPort());
		Marshaller marshaller = new Marshaller();
		Termination termination = new Termination(null);
		Estoque estoque = new Estoque();
		Message msgUnmarshalled = null;
		
		while(true) {
			System.out.println("Running loop...");
			msgUnmarshalled = (Message) marshaller.unmarshall(srh.receive());
			
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
