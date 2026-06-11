package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {

        try {

            String url = "jdbc:mysql://localhost:3306/miniuber";
            String user = "kassia";
            String password = "D_34h.11@hd$2j4";

            return DriverManager.getConnection(url, user, password);

        } catch (Exception e) {

            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}