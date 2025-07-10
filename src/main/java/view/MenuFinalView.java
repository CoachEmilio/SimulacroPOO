package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuFinalView extends JFrame {

    private JButton clientesButton;
    private JButton facturasButton;
    private JButton productosButton;
    private JButton consultasButton;
    private JButton salirButton;

    public MenuFinalView() {
        setTitle("Menú Principal - Sistema Librerías");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        clientesButton = new JButton("Clientes");
        facturasButton = new JButton("Facturas");
        productosButton = new JButton("Productos");
        consultasButton = new JButton("Consultas");
        salirButton = new JButton("Salir");

        add(clientesButton);
        add(facturasButton);
        add(productosButton);
        add(consultasButton);
        add(salirButton);

        clientesButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir gestión de clientes (TODO)"));
        facturasButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir gestión de facturas (TODO)"));

        // Cambia solo este listener:
        productosButton.addActionListener(e -> {
            this.setEnabled(false);
            ConsultaPreciosView consultaView = new ConsultaPreciosView();
            consultaView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            consultaView.setVisible(true);

            consultaView.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    MenuFinalView.this.setEnabled(true);
                    MenuFinalView.this.toFront();
                }
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    MenuFinalView.this.setEnabled(true);
                    MenuFinalView.this.toFront();
                }
            });
        });

        consultasButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir consultas (TODO)"));
        salirButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuFinalView menu = new MenuFinalView();
            menu.setVisible(true);
        });
    }
}