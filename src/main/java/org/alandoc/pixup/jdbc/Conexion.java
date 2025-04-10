package org.alandoc.pixup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion<T> {
    protected Connection connection;

    // Configuración de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/pixup";
    private static final String USER = "root"; // Reemplaza con tu usuario
    private static final String PASSWORD = "n0m3l0"; // Reemplaza con tu contraseña

    public boolean openConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return true; // Conexión exitosa
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return false;
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}