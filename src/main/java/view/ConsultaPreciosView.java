package view;

import controller.ClienteController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ConsultaPreciosView extends JFrame {
    private JComboBox<String> productosCombo;
    private JTextArea resultadosArea;
    private JButton consultarButton;

    public ConsultaPreciosView() {
        setTitle("Consulta de Precios por Producto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Obtener productos reales del controller

        //aca deberia ir el dto de los productos

        List<String> productos = ClienteController.getInstance().getNombresProductos();
        productosCombo = new JComboBox<>(productos.toArray(new String[0]));

        consultarButton = new JButton("Consultar Precios");
        resultadosArea = new JTextArea();
        resultadosArea.setEditable(false);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Producto:"));
        topPanel.add(productosCombo);
        topPanel.add(consultarButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultadosArea), BorderLayout.CENTER);

        consultarButton.addActionListener(this::consultarPrecios);
    }

    private void consultarPrecios(ActionEvent e) {
        int productoID = productosCombo.getSelectedIndex() + 1;
        List<String> precios = ClienteController.getInstance().consultarPreciosPorProducto(productoID);
        resultadosArea.setText("");
        for (String precio : precios) {
            resultadosArea.append(precio + "\n");
        }
    }
}