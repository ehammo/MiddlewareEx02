package infraEstrutura;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
 
public class EstoqueSQLite extends UnicastRemoteObject implements IEstoque {
    Connection c;
    Statement stmt;
    
    public EstoqueSQLite() throws RemoteException {
        this.c = null;
        this.stmt = null;
 
        try {
            this.c = DBUtil.connection();
 
            this.stmt = this.c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS ESTOQUE " +
                    "(PRODUTO TEXT PRIMARY KEY NOT NULL," +
                    " QTD INT NOT NULL)";
 
            this.stmt.executeUpdate(sql);
            this.stmt.close();
            this.c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
 
    public String add(String produto) {
        int qtd =0;
    	try {
            this.c = DBUtil.connection();
           
            if(DBUtil.exists(c, produto)) {
                qtd = DBUtil.getQtd(c, produto);
                DBUtil.update(c, produto, qtd + 1);
            } else {
                DBUtil.insert(c, produto);
            }
            qtd = DBUtil.getQtd(c, produto);
            this.c.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Add " + produto + ", qtd = " + qtd;
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