package com.softtek.Abril18Productos.modelo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Productos {

    private int idProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int unidadesStock;
    private int idCategoria;



}

