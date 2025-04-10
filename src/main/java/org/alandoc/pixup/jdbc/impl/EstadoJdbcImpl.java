package org.alandoc.pixup.jdbc.impl;

import org.alandoc.pixup.jdbc.Conexion;
import org.alandoc.pixup.jdbc.EstadoJdbc;
import org.alandoc.pixup.model.Estado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EstadoJdbcImpl extends Conexion<Estado> implements EstadoJdbc {
    private static EstadoJdbcImpl estadoJdbc;

    private EstadoJdbcImpl() {
        super();
    }

    public static EstadoJdbcImpl getInstance() {
        if (estadoJdbc == null) {
            estadoJdbc = new EstadoJdbcImpl();
        }
        return estadoJdbc;
    }

    @Override
    public List<Estado> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Estado> list = null;
        Estado estado;
        String sql = "SELECT id, nombre FROM TBL_ESTADO"; // Verifica nombres correctos

        try {
            if (!openConnection()) {  // Abre conexión
                return null;
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet == null) {
                return null;
            }

            list = new java.util.ArrayList<>();
            while (resultSet.next()) {
                estado = new Estado();
                estado.setId(resultSet.getInt("id"));
                estado.setNombre(resultSet.getString("nombre")); // Verifica que "ESTADO" sea correcto
                list.add(estado);
            }

            resultSet.close();
            statement.close();
            closeConnection();  // Cierra conexión

            return list;
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
            return null;
        }
    }


        public static void main(String[] args) {
            // Obtener instancia de EstadoJdbcImpl
            EstadoJdbcImpl estadoJdbc = EstadoJdbcImpl.getInstance();

            // Obtener lista de estados
            List<Estado> estados = estadoJdbc.findAll();

            // Imprimir resultados
            if (estados != null && !estados.isEmpty()) {
                System.out.println("Listado de Estados:");
                for (Estado estado : estados) {
                    System.out.println("ID: " + estado.getId() + ", Estado: " + estado.getNombre());
                }
            } else {
                System.out.println("No se encontraron estados o hubo un error.");
            }
        }



}

