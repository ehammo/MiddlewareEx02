package infraEstrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class DBUtil {
    public static Connection connection() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
    	Connection c = DriverManager.getConnection("jdbc:sqlite:estoque.db");
        return c;
    }
   
    public static void insert(Connection c, String produto) throws SQLException {
        Statement stmt = c.createStatement();
        String sql = "INSERT INTO ESTOQUE (PRODUTO, QTD) " +
                "VALUES ('" + produto + "', 1);";
        stmt.executeUpdate(sql);
        stmt.close();
    }
 
    public static void update(Connection c, String produto, int qtd) throws SQLException {
        Statement stmt = c.createStatement();
        String sql = "UPDATE ESTOQUE set QTD = " + qtd + " where PRODUTO='"+ produto +"';";
        stmt.executeUpdate(sql);
        c.commit();
        stmt.close();
    }
 
    public static boolean exists(Connection c, String produto) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM ESTOQUE WHERE PRODUTO='"+ produto +"';" );
        return rs.next();
    }
 
    public static int getQtd(Connection c, String produto) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT qtd FROM ESTOQUE WHERE PRODUTO='"+ produto +"';" );
        int qtd = rs.next() ? rs.getInt("qtd") : 0;
        rs.close();
        stmt.close();
        return qtd;
    }
 
    public static void list(Connection c) throws SQLException {
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM ESTOQUE;" );
 
        while (rs.next()) {
            String produto = rs.getString("produto");
            int qtd  = rs.getInt("qtd");
 
            System.out.println("Produto: " + produto);
            System.out.println("Quantidade: " + qtd);
            System.out.println();
        }
        rs.close();
        stmt.close();
    }
}