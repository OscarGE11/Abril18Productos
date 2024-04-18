package com.softtek.Abril18Productos.controlador;

import com.softtek.Abril18Productos.modelo.Productos;
import com.softtek.Abril18Productos.repo.IProductosRepo;
import com.softtek.Abril18Productos.repo.ProductosRepo;
import com.softtek.Abril18Productos.servicio.IProductosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProductos {
    @Autowired
    private IProductosServicio servicio;

    @GetMapping
    public List<Productos> obtenerTodos() throws SQLException, ClassNotFoundException {

        return servicio.obtenerTodos();
    }
    @GetMapping("/{id}")
    public Productos obtenerUno(@PathVariable int id) throws SQLException, ClassNotFoundException {
        return servicio.obtenerUno(id);
    }
    @PostMapping
    public Productos insertarProducto(@RequestBody Productos producto) throws SQLException, ClassNotFoundException {
        return servicio.insertarProducto(producto);
    }
    @PutMapping
    public Productos actualizarProducto(@RequestBody Productos productos) throws SQLException, ClassNotFoundException {
        return servicio.actualizarProducto(productos);
    }
    @DeleteMapping("/{id}")
    public void borrarProducto(@PathVariable int id) throws SQLException, ClassNotFoundException {
        servicio.borrarProducto(id);
    }

}
