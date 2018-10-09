package distribuicao.message;

import java.util.ArrayList;

public class Message {
	int requestId;
	String operation;
	ArrayList<Object> parameters;
	Object operationResult;
	
	public Message(int requestId, String operation, ArrayList<Object> parameters, Object operationResult) {
		super();
		this.requestId = requestId;
		this.operation = operation;
		this.parameters = parameters;
		this.operationResult = operationResult;
	}
}
