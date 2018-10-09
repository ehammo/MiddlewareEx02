package distribuicao;

import java.util.ArrayList;

public class Invocation {
	private int objectId;
	private String ipAddress;
	private int portNumber;
	private String operation;
	private ArrayList<Object> parameters;
	
	public Invocation(int objectId, String ipAddress, int portNumber, String operation,
			ArrayList<Object> parameters) {
		super();
		this.objectId = objectId;
		this.ipAddress = ipAddress;
		this.portNumber = portNumber;
		this.operation = operation;
		this.parameters = parameters;
	}
	
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public ArrayList<Object> getParameters() {
		return parameters;
	}

	public void setParameters(ArrayList<Object> parameters) {
		this.parameters = parameters;
	}
}
