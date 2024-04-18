package com.softtek.Abril18Productos.servicio;

import com.softtek.Abril18Productos.modelo.Productos;
import com.softtek.Abril18Productos.repo.IProductosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductosServicio implements IProductosServicio{
    @Autowired
    private IProductosRepo repo;

    @Override
    public List<Productos> obtenerTodos() throws ClassNotFoundException, SQLException {
        return repo.obtenerTodos();
    }

    @Override
    public Productos obtenerUno(int id) throws ClassNotFoundException, SQLException {
        return repo.obtenerUno(id);
    }

    @Override
    public void insertarProducto(Productos producto) throws ClassNotFoundException, SQLException {
        repo.insertarProducto(producto);
    }

    @Override
    public void actualizarProducto(Productos producto) throws ClassNotFoundException, SQLException {
        repo.actualizarProducto(producto);
    }

    @Override
    public void borrarProducto(int id) throws ClassNotFoundException, SQLException {
        repo.borrarProducto(id);
    }
}
