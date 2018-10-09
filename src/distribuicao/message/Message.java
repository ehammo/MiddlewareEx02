package distribuicao.message;

public class Message {
	MessageHeader header;
	MessageBody body;
	
	public Message(MessageHeader header, MessageBody body) {
		this.header = header;
		this.body = body;
	}
}
