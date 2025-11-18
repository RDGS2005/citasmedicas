package dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySQLDataHelper{
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PSWD = "";
    private static Connection conn = null;

    protected MySQLDataHelper(){}
    protected static synchronized Connection conectarBD() throws Exception
    {
        try
        {
            if(conn == null)
            {
                conn = DriverManager.getConnection(URL, USER, PSWD);
                String currentDB = null;
                String query = "SELECT DATABASE();";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) currentDB = rs.getString(1);

                System.out.println("Conectado a " + currentDB);
            }
            else
            {
                System.out.println("Ya conectado!");
            }
        }
        catch (SQLException e)
        {
            throw e;
        }
        return conn;
    }
    protected static void desconectarBD() throws Exception
    {
        try {
            if (conn != null)
            {
                conn.close();
                System.out.println("Desconexion Exitosa!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}