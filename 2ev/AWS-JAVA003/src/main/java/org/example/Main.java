package org.example;

import org.example.Pelicula;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        // Conectar a la base de datos mediante Singleton
        ConexionPostgre conexion = ConexionPostgre.getInstance();
        System.out.println("✅ Conexión establecida en Main");

        menu.menu();
    }
}