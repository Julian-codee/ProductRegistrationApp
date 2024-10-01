package com.inventario.main;
// Declara el paquete donde se encuentra la clase Main

import com.inventario.gui.ProductRegistrationFrame;
// Importa la clase ProductRegistrationFrame
import javax.swing.SwingUtilities;
// Importa SwingUtilities para manejar el inicio de la interfaz gráfica en el hilo de eventos de Swing

public class Main {
    public static void main(String[] args) {
        // Método principal de la aplicación

        // Ejecuta la creación y visualización del marco en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            ProductRegistrationFrame frame = new ProductRegistrationFrame();
            // Crea una instancia de ProductRegistrationFrame
            frame.setVisible(true);
            // Hace visible la ventana
        });
    }
}