package dataAccess;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLDataHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/citasmedicas";
    private static final String USER = "root";
    private static final String PSWD = "";

    protected MySQLDataHelper(){}

    public Connection conectarBD() throws SQLException {
        // NO usar variable local
        return DriverManager.getConnection(URL, USER, PSWD);
    }

    protected static void desconectarBD(Connection conn) throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
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

