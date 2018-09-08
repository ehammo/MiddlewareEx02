package middleware;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IEstoque extends Remote {

	String host = "//127.0.0.1:1020/Estoque";
	int port = 1020;
	
	String add(String item) throws RemoteException;
	
	String remove(String item) throws RemoteException;

	String getAll() throws RemoteException;
	
}
