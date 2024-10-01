package com.inventario.gui;
// Declara el paquete donde se encuentra la clase ProductRegistrationFrame

import javax.swing.*;
// Importa las clases de Swing para crear la interfaz gráfica
import java.awt.*;
// Importa las clases de AWT para diseño y disposición de los componentes
import java.awt.event.ActionEvent;
// Importa ActionEvent para manejar eventos de acción (como clics en botones)
import java.awt.event.ActionListener;
// Importa ActionListener para manejar la lógica de los eventos de acción
import com.inventario.model.*;
// Importa las clases Product y ProductTableModel desde el paquete model

public class ProductRegistrationFrame extends JFrame {
    // Clase que extiende JFrame y representa la ventana para registrar productos

    // Declaración de los campos de texto y otros componentes de la interfaz
    private JTextField idField, nameField, priceField, quantityField;
    private JButton saveButton;
    private JTable productTable;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame() {
        // Constructor que configura las propiedades iniciales de la ventana
        setTitle("Registro de Productos");
        // Define el título de la ventana
        setSize(600, 400);
        // Define el tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Configura la operación por defecto al cerrar la ventana (salir de la aplicación)
        setLocationRelativeTo(null);
        // Centra la ventana en la pantalla

        initComponents();
        // Llama al método que inicializa los componentes de la interfaz
    }

    private void initComponents() {
        // Método que inicializa los componentes de la interfaz

        productTableModel = new ProductTableModel();
        // Crea una instancia del modelo de tabla
        productTable = new JTable(productTableModel);
        // Crea una tabla utilizando el modelo de productos

        // Crea los campos de texto para capturar los datos del producto
        idField = new JTextField(10);
        nameField = new JTextField(20);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);

        // Crea el botón de guardar y agrega un ActionListener que responde al clic
        saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
                // Llama al método saveProduct() cuando el botón es presionado
            }
        });

        // Crea un panel de formulario y añade los campos y el botón en una cuadrícula
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Nombre:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Precio:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Cantidad:"));
        formPanel.add(quantityField);
        formPanel.add(new JLabel(""));
        formPanel.add(saveButton);
        // Añade los componentes al panel del formulario

        // Configura el diseño principal de la ventana y añade el formulario y la tabla
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.NORTH);
        // Añade el formulario en la parte superior
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        // Añade la tabla en el centro, con capacidad de desplazarse
    }

    private void saveProduct() {
        // Método que guarda un producto cuando se presiona el botón de guardar

        // Obtiene los valores de los campos de texto
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        double price = Double.parseDouble(priceField.getText());
        int quantity = Integer.parseInt(quantityField.getText());

        // Crea un nuevo producto con los valores obtenidos
        Product product = new Product(id, name, price, quantity);
        productTableModel.addProduct(product);
        // Añade el producto al modelo de la tabla

        // Limpia los campos de texto para poder ingresar un nuevo producto
        idField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }
}
