package com.softtek.Abril18Productos.servicio;

import com.softtek.Abril18Productos.modelo.Productos;

import java.sql.SQLException;
import java.util.List;

public interface IProductosServicio {
    public List<Productos> obtenerTodos() throws ClassNotFoundException, SQLException;

    public Productos obtenerUno(int id) throws ClassNotFoundException, SQLException;

    public Productos insertarProducto(Productos producto) throws ClassNotFoundException, SQLException;

    public Productos actualizarProducto(Productos producto) throws ClassNotFoundException, SQLException;

    public void borrarProducto(int id) throws ClassNotFoundException, SQLException;

}
