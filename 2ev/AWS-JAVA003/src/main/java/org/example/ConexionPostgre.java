package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPostgre {
    private static ConexionPostgre instance;
    private Connection connection;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; // url local posgres clase
    //private static final String URL = "jdbc:postgresql://localhost:5433/postgres"; //url posgres del docker
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    private ConexionPostgre() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión establecida con PostgreSQL (Singleton)");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a PostgreSQL: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static ConexionPostgre getInstance() {
        if (instance == null) {
            instance = new ConexionPostgre();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}

