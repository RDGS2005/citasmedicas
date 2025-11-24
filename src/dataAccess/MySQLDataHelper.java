package dataAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class MySQLDataHelper{
    private static final String URL = "jdbc:mysql://localhost:3306/citasmedicas";
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
    protected static String sha256(String original) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(original.getBytes());

            // Convert bytes to hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}