package distribuicao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import distribuicao.message.Message;
import infraEstrutura.IEstoque;

public class EstoqueProxy extends ClientProxy implements IEstoque {
	private static final long serialVersionUID = 1L;

	public EstoqueProxy(String host, int port, int objectId) {
		super(host, port, objectId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String add(String item) throws RemoteException {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(item);
		Invocation inv = new Invocation(super.getObjectId(), super.getHost(), super.getPort(), "add", parameters);
		Requestor req = new Requestor();
		Termination result = null;
		try {
			result = req.invoke(inv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ((Message) result.getResult()).getOperationResult().toString();
	}

	@Override
	public String remove(String item) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
