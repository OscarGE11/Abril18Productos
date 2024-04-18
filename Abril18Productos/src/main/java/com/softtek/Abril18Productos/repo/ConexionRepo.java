package com.softtek.Abril18Productos.repo;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Repository
public class ConexionRepo {

    protected Connection miConexion;

    public void abrirConexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        miConexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/northwind",
                "postgres","1234");
        System.out.println("Exito al abrir la conexion");

    }
}
