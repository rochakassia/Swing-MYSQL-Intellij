package uberapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/miniuber";

    private static final String USER = "root";
    private static final String PASSWORD = "D_34h.11@hd$2j4";

    public static Connection conectar() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return null;
        }
    }
}