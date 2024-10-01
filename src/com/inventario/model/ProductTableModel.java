package com.inventario.model;
// Declara el paquete donde se encuentra ProductTableModel

import javax.swing.table.AbstractTableModel;
// Importa la clase AbstractTableModel, que será extendida para crear nuestro modelo personalizado
import java.util.List;
// Importa la interfaz List para manejar una lista de productos
import java.util.ArrayList;
// Importa la clase ArrayList para instanciar la lista de productos

public class ProductTableModel extends AbstractTableModel {
    // Clase que extiende AbstractTableModel para definir un modelo de tabla personalizado

    private final List<Product> productList;
    // Lista que almacena los productos
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"};
    // Arreglo de cadenas que almacena los nombres de las columnas de la tabla

    public ProductTableModel() {
        // Constructor que inicializa la lista de productos como un ArrayList vacío
        this.productList = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        // Retorna la cantidad de filas en la tabla (cantidad de productos en la lista)
        return productList.size();
        // Devuelve el tamaño de la lista de productos
    }

    @Override
    public int getColumnCount() {
        // Retorna la cantidad de columnas en la tabla (4 columnas: ID, Nombre, Precio, Cantidad)
        return columnNames.length;
        // Devuelve la longitud del arreglo de nombres de columnas
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Retorna el valor de una celda específica dada por su fila y columna
        Product product = productList.get(rowIndex);
        // Obtiene el producto en la fila correspondiente
        switch (columnIndex) {
            // Evalúa qué columna es para retornar el valor correcto del producto
            case 0: return product.getId();
            // Retorna el ID si está en la primera columna
            case 1: return product.getName();
            // Retorna el nombre si está en la segunda columna
            case 2: return product.getPrice();
            // Retorna el precio si está en la tercera columna
            case 3: return product.getQuantity();
            // Retorna la cantidad si está en la cuarta columna
            default: return null;
            // Retorna null en caso de una columna no válida (no debería ocurrir)
        }
    }

    @Override
    public String getColumnName(int column) {
        // Retorna el nombre de la columna para mostrarlo en el encabezado de la tabla
        return columnNames[column];
        // Devuelve el nombre correspondiente al índice de la columna
    }

    public void addProduct(Product product) {
        // Método que agrega un nuevo producto a la lista
        productList.add(product);
        // Añade el producto a la lista
        fireTableRowsInserted(productList.size() - 1, productList.size() - 1);
        // Notifica a la tabla que se ha insertado una nueva fila para que se actualice la vista
    }
}
