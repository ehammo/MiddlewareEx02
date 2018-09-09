package middleware;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IEstoque extends Remote {

	int port = 12345;
	String host = String.format("//127.0.0.1:%1$d/Estoque", port);

	
	String add(String item) throws RemoteException;
	
	String remove(String item) throws RemoteException;

	String getAll() throws RemoteException;
	
}
