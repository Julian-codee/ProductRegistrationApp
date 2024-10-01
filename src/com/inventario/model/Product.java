package com.inventario.model;
// Declara el paquete donde se encuentra la clase Product

public class Product {
    // Clase pública Product que representa un producto con sus propiedades

    private int id;
    // Campo privado que almacena el ID del producto
    private String name;
    // Campo privado que almacena el nombre del producto
    private double price;
    // Campo privado que almacena el precio del producto
    private int quantity;
    // Campo privado que almacena la cantidad del producto en inventario

    // Constructor que inicializa los campos de la clase con los valores proporcionados
    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        // Asigna el valor del ID
        this.name = name;
        // Asigna el valor del nombre
        this.price = price;
        // Asigna el valor del precio
        this.quantity = quantity;
        // Asigna el valor de la cantidad
    }

    // Métodos getters que permiten acceder a los campos de la clase
    public int getId() {
        return id;
        // Retorna el ID del producto
    }

    public String getName() {
        return name;
        // Retorna el nombre del producto
    }

    public double getPrice() {
        return price;
        // Retorna el precio del producto
    }

    public int getQuantity() {
        return quantity;
        // Retorna la cantidad de productos disponibles
    }

    // Métodos setters que permiten modificar los valores de los campos de la clase
    public void setId(int id) {
        this.id = id;
        // Asigna un nuevo valor al ID
    }

    public void setName(String name) {
        this.name = name;
        // Asigna un nuevo valor al nombre
    }

    public void setPrice(double price) {
        this.price = price;
        // Asigna un nuevo valor al precio
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        // Asigna un nuevo valor a la cantidad
    }
}
