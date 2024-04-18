package com.softtek.Abril18Productos.repo;

import com.softtek.Abril18Productos.modelo.Productos;


import java.sql.SQLException;
import java.util.List;

public interface IProductosRepo {

    public List<Productos> obtenerTodos() throws ClassNotFoundException, SQLException;
    public Productos obtenerUno(int id) throws ClassNotFoundException, SQLException;
    public void insertarProducto(Productos producto) throws ClassNotFoundException, SQLException;
    public void actualizarProducto(Productos producto) throws ClassNotFoundException, SQLException;
    public void borrarProducto(int id) throws ClassNotFoundException, SQLException;
}
