package distribuicao;

import java.rmi.RemoteException;

import infraEstrutura.IEstoque;

public class EstoqueProxy extends ClientProxy implements IEstoque {
	private static final long serialVersionUID = 1L;

	public EstoqueProxy(String host, int port, int objectId) {
		super(host, port, objectId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String add(String item) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
