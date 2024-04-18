package com.softtek.Abril18Productos.repo;

import com.softtek.Abril18Productos.modelo.Productos;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductosRepo extends ConexionRepo implements IProductosRepo{

    @Override
    public List<Productos> obtenerTodos() throws ClassNotFoundException, SQLException {
        Statement sentencia;
        ResultSet resultado;

        String sql = "Select product_id,product_name,unit_price,units_in_stock,category_id from                products;";
        List<Productos> productos = new ArrayList<>();
        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        while (resultado.next()) {
            productos.add(new Productos(resultado.getInt("product_id"),
                    resultado.getString("product_name"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("units_in_stock"),
                    resultado.getInt("category_id")
            ));
        }
        return productos;
    }
    @Override
    public Productos obtenerUno(int id) throws ClassNotFoundException, SQLException {

        Statement sentencia;
        ResultSet resultado;

        String sql = "Select product_id,product_name,unit_price,units_in_stock,category_id from products " +
                "where product_id=" + id;


        abrirConexion();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);

        resultado.next();
        Productos producto = new Productos(resultado.getInt("product_id"),
                resultado.getString("product_name"),
                resultado.getDouble("unit_price"),
                resultado.getInt("units_in_stock"),
                resultado.getInt("category_id")

        );
        return producto;
    }
    @Override
    public void insertarProducto(Productos producto) throws SQLException, ClassNotFoundException {

        int idProducto = producto.getIdProducto();
        int unidadesStock = producto.getUnidadesStock();
        String nombreProducto = producto.getNombreProducto();
        double precioUnitario = producto.getPrecioUnitario();


        Statement sentencia;
        int resultado;

        if (!comprobarProducto(idProducto)) {
            String sql = "INSERT INTO products (product_id, product_name, unit_price, units_in_stock,discontinued) " +
                    "VALUES " +
                    "(" + idProducto + ", '" + nombreProducto + "', " + precioUnitario + ", " + unidadesStock + ", 0)";


            abrirConexion();
            sentencia = miConexion.createStatement();
            resultado = sentencia.executeUpdate(sql);

            System.out.println("Correctamente añadido");
        }else {
            System.out.println("No se puede insertar porque ya existe");
        }


    }
    @Override
    public void actualizarProducto(Productos producto) throws SQLException, ClassNotFoundException {


        int idProducto = producto.getIdProducto();
        int unidadesStock = producto.getUnidadesStock();
        String nombreProducto = producto.getNombreProducto();
        double precioUnitario = producto.getPrecioUnitario();

        Statement sentencia;
        int resultado;
        abrirConexion();
        if (comprobarProducto(idProducto)){
            String sql = "UPDATE products SET product_id=" + idProducto + ", product_name='" + nombreProducto +
                    "', unit_price=" + precioUnitario + ", units_in_stock=" + unidadesStock + " WHERE " +
                    "product_id=" + idProducto;

            sentencia = miConexion.createStatement();
            resultado = sentencia.executeUpdate(sql);

            System.out.println("Correctamente actualizado");}
        else {
            System.out.println("No existe el producto");
        }
    }
    @Override
    public void borrarProducto(int id) throws SQLException, ClassNotFoundException {
        Statement sentencia;
        abrirConexion();
        if (comprobarProducto(id)) {

            String sql = "DELETE FROM products WHERE product_id=" + id;

            sentencia = miConexion.createStatement();
            int filasAfectadas = sentencia.executeUpdate(sql);

            System.out.println("Borrado correctamente");
        }
        else {
            System.out.println("No existe producto");
        }
    }

    public boolean comprobarProducto(int idProducto) throws ClassNotFoundException, SQLException {
        abrirConexion();

        String sql = "Select COUNT(*) from products where product_id="+idProducto;

        Statement sentencia;
        ResultSet resultado;
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        resultado.next();

        int cantidadEncontrados = resultado.getInt(1);
        return cantidadEncontrados > 0;


    }


}

