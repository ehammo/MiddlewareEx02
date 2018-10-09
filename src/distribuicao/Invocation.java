package distribuicao;

import java.util.ArrayList;

public class Invocation {
	int objectId;
	String ipAddress;
	int portNumber;
	String operation;
	ArrayList<Object> parameters;
	
	public Invocation(int objectId, String ipAddress, int portNumber, String operation,
			ArrayList<Object> parameters) {
		super();
		this.objectId = objectId;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.operation = operation;
		this.parameters = parameters;
	}
}
