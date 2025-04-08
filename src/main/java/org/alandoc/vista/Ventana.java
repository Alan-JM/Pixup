package org.alandoc.vista;

import org.alandoc.model.Estado;
import org.alandoc.util.ReadUtil;
import org.alandoc.inicio.Inicio;

import javax.swing.*;

    public class Ventana extends JFrame implements Ejecutable {
        private static org.alandoc.vista.Ventana ventana;
        private JLabel jLabel;
        private JTextField jTextField;
        private JButton jButton;
        private Estado estado;

        private Ventana() {
            super("Programa de figuras");
            init();
        }

        private void init() {
            jLabel = new JLabel("Dame un lado");
            jLabel.setBounds(10, 10, 100, 20);
            jTextField = new JTextField();
            jTextField.setBounds(120, 10, 100, 20);
            jButton = new JButton("Calcular");
            jButton.setBounds(10, 40, 100, 20);

        }

        public static org.alandoc.vista.Ventana getInstance() {
            if (ventana == null) {
                ventana = new org.alandoc.vista.Ventana();
            }
            return ventana;
        }

        @Override
        public void run() {

        }
    }

