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
    public Productos insertarProducto(Productos producto) throws ClassNotFoundException, SQLException {
        return repo.insertarProducto(producto);
    }

    @Override
    public Productos actualizarProducto(Productos producto) throws ClassNotFoundException, SQLException {
        return repo.actualizarProducto(producto);
    }

    @Override
    public void borrarProducto(int id) throws ClassNotFoundException, SQLException {
        repo.borrarProducto(id);
    }
}
