package edu.ecu.ec.ProyectoEmprendimiento.View;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Client;
import edu.ecu.ec.ProyectoEmprendimiento.Models.Products;
import edu.ecu.ec.ProyectoEmprendimiento.Services.ClientService;
import edu.ecu.ec.ProyectoEmprendimiento.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class InventarioClient extends JFrame {

    private DefaultTableModel tableModel;
    @Autowired
    ClientService clientService;

    public InventarioClient() {
        initComponents();
        setExtendedState(VentasFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {

        fondoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mostrarButton = new javax.swing.JButton();
        actualizarButton1 = new javax.swing.JButton();
        buscarButton1 = new javax.swing.JButton();
        eliminarButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clientes");
        setResizable(false);

        getContentPane().setBackground(new java.awt.Color(221, 202, 155));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png"))).getImage());

        ImageIcon logoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/clientes.png")));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        fondoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondoLabel.setIcon(new ImageIcon(scaledLogo));
        fondoLabel.setPreferredSize(new Dimension(500, 500));

        fondoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Placa", "Nombre", "Email", "Telefono", "Dirección"}
        );
        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        mostrarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mostrarButton.setForeground(new java.awt.Color(45, 77, 90));
        mostrarButton.setText("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarButtonActionPerformed(e);
            }
        });

        actualizarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        actualizarButton1.setForeground(new java.awt.Color(45, 77, 90));
        actualizarButton1.setText("Actualizar");
        actualizarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarButtonActionPerformed(e);
            }
        });

        buscarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarButton1.setForeground(new java.awt.Color(45, 77, 90));
        buscarButton1.setText("Buscar");
        buscarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarButtonActionPerformed(e);
            }
        });

        eliminarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarButton1.setForeground(new java.awt.Color(45, 77, 90));
        eliminarButton1.setText("Eliminar");
        eliminarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarButtonActionPerformed(e);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fondoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(mostrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(actualizarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(eliminarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(fondoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(actualizarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(buscarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(49, 49, 49)
                                                .addComponent(eliminarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(mostrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }

    private void mostrarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        List<Client> clients = clientService.getAllClients();
        tableModel.setRowCount(0); // Limpiar la tabla
        for (Client client : clients) {
            tableModel.addRow(new Object[]{client.getPlaca(), client.getName_client(), client.getEmail(), client.getPhone(), client.getDir()});
        }
    }

    private void actualizarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String placa = JOptionPane.showInputDialog(this, "Ingrese la placa del cliente:");
        if (placa != null && !placa.trim().isEmpty()) {
            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre del cliente:");
            String email = JOptionPane.showInputDialog(this, "Ingrese el nuevo email del cliente:");
            String telefono = JOptionPane.showInputDialog(this, "Ingrese el nuevo teléfono del cliente:");
            String direccion = JOptionPane.showInputDialog(this, "Ingrese la nueva dirección del cliente:");

            Client updatedClient = new Client();
            updatedClient.setPlaca(placa);
            updatedClient.setName_client(nombre);
            updatedClient.setEmail(email);
            updatedClient.setPhone(telefono);
            updatedClient.setDir(direccion);

            Client result = clientService.updateClient(placa, updatedClient);
            if (result != null) {
                JOptionPane.showMessageDialog(this, "Cliente actualizado exitosamente.");
                mostrarButtonActionPerformed(evt); // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            }
        }
    }

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String placa = JOptionPane.showInputDialog(this, "Ingrese la placa del cliente:");
        if (placa != null && !placa.trim().isEmpty()) {
            Client client = clientService.findByPlaca(placa);
            if (client != null) {
                tableModel.setRowCount(0); // Limpiar la tabla
                tableModel.addRow(new Object[]{client.getPlaca(), client.getName_client(), client.getEmail(), client.getPhone(), client.getDir()});
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            }
        }
    }

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String placa = JOptionPane.showInputDialog(this, "Ingrese la placa del cliente a eliminar:");
        if (placa != null && !placa.trim().isEmpty()) {
            boolean deleted = clientService.deleteClientByPlaca(placa);
            if (deleted) {
                JOptionPane.showMessageDialog(this, "Cliente eliminado exitosamente.");
                mostrarButtonActionPerformed(evt); // Refrescar la tabla
            } else {
                JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            }
        }
    }

    private JButton actualizarButton1, buscarButton1, eliminarButton1, mostrarButton;
    private JLabel fondoLabel;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
}
