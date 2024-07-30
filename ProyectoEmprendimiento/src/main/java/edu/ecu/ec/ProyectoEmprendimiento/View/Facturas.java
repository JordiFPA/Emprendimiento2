package edu.ecu.ec.ProyectoEmprendimiento.View;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Invoice;
import edu.ecu.ec.ProyectoEmprendimiento.Models.Trabajadores;
import edu.ecu.ec.ProyectoEmprendimiento.Services.InvoiceService;
import edu.ecu.ec.ProyectoEmprendimiento.Services.TrabajadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Component
public class Facturas extends JFrame {
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    TrabajadoresService trabajadoresService;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;


    public Facturas() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(221, 202, 155));

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null,null},
                        {null, null, null, null,null},
                        {null, null, null, null,null},
                        {null, null, null, null,null}
                },
                new String[]{
                        "ID", "CLIENTE", "PLACA", "FECHA EMISIÓN", "TOTAL"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton1.setText("Mostrar Facturas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            mostrarFacturas(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setText("Buscar Factura");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFactura(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton3.setText("Eliminar Trabajador");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTrabajador(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Cédula", "Nombre", "Rango", "Contraseña"
                }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton4.setText("Listar Trabajadores");
        jButton4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listarTrabajadores(e);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton5.setText("Buscar Trabajador");
        jButton5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTrabajador(e);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton6.setText("Agregar Trabajador");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTrabajador(evt);
            }
        });


        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel2.setText("Administrar Trabajadores");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1))
                                                .addGap(231, 231, 231)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(83, 83, 83))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }


    private void mostrarFacturas(ActionEvent evt) {
        List<Invoice> facturas = invoiceService.getAllInvoices();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Invoice factura : facturas) {
            model.addRow(new Object[]{
                    factura.getId(),
                    factura.getClient().getName_client(),
                    factura.getClient().getPlaca(),
                    factura.getIssueDate(),
                    factura.getTotalAmount()
            });
        }
    }

    private void buscarFactura(ActionEvent evt) {
        String placa = JOptionPane.showInputDialog(this, "Ingrese la placa del cliente:", "Buscar Factura", JOptionPane.QUESTION_MESSAGE);
        if (placa != null && !placa.trim().isEmpty()) {
            try {
                List<Invoice> facturas = invoiceService.getInvoicesByPlaca(placa);
                if (facturas.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontraron facturas para la placa ingresada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.setRowCount(0); // Clear existing rows

                    for (Invoice factura : facturas) {
                        model.addRow(new Object[]{
                                factura.getId(),
                                factura.getClient().getName_client(),
                                factura.getClient().getPlaca(),
                                factura.getIssueDate(),
                                factura.getTotalAmount()
                        });
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar las facturas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar una placa.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void agregarTrabajador(ActionEvent evt) {
        try {
            String cedulaStr = JOptionPane.showInputDialog(this, "Ingrese la cédula del trabajador:", "Agregar Trabajador", JOptionPane.QUESTION_MESSAGE);
            if (cedulaStr == null || cedulaStr.trim().isEmpty()) {
                throw new IllegalArgumentException("La cédula es obligatoria.");
            }
            Long cedula = Long.parseLong(cedulaStr);

            String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del trabajador:", "Agregar Trabajador", JOptionPane.QUESTION_MESSAGE);
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }

            String rango = JOptionPane.showInputDialog(this, "Ingrese el rango del trabajador:", "Agregar Trabajador", JOptionPane.QUESTION_MESSAGE);
            if (rango == null || rango.trim().isEmpty()) {
                throw new IllegalArgumentException("El rango es obligatorio.");
            }

            String contraseña = JOptionPane.showInputDialog(this, "Ingrese la contraseña del trabajador:", "Agregar Trabajador", JOptionPane.QUESTION_MESSAGE);
            if (contraseña == null || contraseña.trim().isEmpty()) {
                throw new IllegalArgumentException("La contraseña es obligatoria.");
            }

            Trabajadores nuevoTrabajador = new Trabajadores(cedula, nombre, rango, contraseña);
            trabajadoresService.createTrabajador(nuevoTrabajador);

            JOptionPane.showMessageDialog(this, "Trabajador agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Actualizar la tabla de trabajadores
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.addRow(new Object[]{
                    nuevoTrabajador.getCedula(),
                    nuevoTrabajador.getNombre(),
                    nuevoTrabajador.getRango(),
                    nuevoTrabajador.getContraseña()
            });
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cédula debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al agregar el trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void listarTrabajadores(ActionEvent evt) {
        try {
            List<Trabajadores> trabajadores = trabajadoresService.getAllTrabajadores(); // Asumiendo que tienes un método para obtener todos los trabajadores
            DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            model.setRowCount(0); // Limpiar filas existentes

            for (Trabajadores trabajador : trabajadores) {
                model.addRow(new Object[]{
                        trabajador.getCedula(),
                        trabajador.getNombre(),
                        trabajador.getRango(),
                        trabajador.getContraseña()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al listar los trabajadores: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void buscarTrabajador(ActionEvent evt) {
        String cedulaStr = JOptionPane.showInputDialog(this, "Ingrese la cédula del trabajador:", "Buscar Trabajador", JOptionPane.QUESTION_MESSAGE);
        if (cedulaStr != null && !cedulaStr.trim().isEmpty()) {
            try {
                Long cedula = Long.parseLong(cedulaStr);
                Trabajadores trabajador = trabajadoresService.buscarTrabajador(cedula);

                if (trabajador == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró trabajador con la cédula ingresada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0); // Clear existing rows

                    model.addRow(new Object[]{
                            trabajador.getCedula(),
                            trabajador.getNombre(),
                            trabajador.getRango(),
                            trabajador.getContraseña()
                    });
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La cédula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar el trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cédula.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void eliminarTrabajador(ActionEvent evt) {
        String cedulaStr = JOptionPane.showInputDialog(this, "Ingrese la cédula del trabajador a eliminar:", "Eliminar Trabajador", JOptionPane.QUESTION_MESSAGE);
        if (cedulaStr != null && !cedulaStr.trim().isEmpty()) {
            try {
                Long cedula = Long.parseLong(cedulaStr);

                // Verificar si el trabajador existe
                Trabajadores trabajador = trabajadoresService.buscarTrabajador(cedula);
                if (trabajador == null) {
                    JOptionPane.showMessageDialog(this, "No se encontró trabajador con la cédula ingresada.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                // Confirmar eliminación
                int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar al trabajador con cédula " + cedula + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    trabajadoresService.eliminarTrabajador(cedula);
                    JOptionPane.showMessageDialog(this, "Trabajador eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    // Actualizar la tabla de trabajadores
                    DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                    model.setRowCount(0); // Limpiar la tabla
                    List<Trabajadores> trabajadores = trabajadoresService.getAllTrabajadores();
                    for (Trabajadores t : trabajadores) {
                        model.addRow(new Object[]{
                                t.getCedula(),
                                t.getNombre(),
                                t.getRango(),
                                t.getContraseña()
                        });
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La cédula debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar el trabajador: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar una cédula.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





}
