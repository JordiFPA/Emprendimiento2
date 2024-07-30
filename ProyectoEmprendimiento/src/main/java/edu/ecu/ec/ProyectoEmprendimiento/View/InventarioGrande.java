package edu.ecu.ec.ProyectoEmprendimiento.View;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Products;
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
public class InventarioGrande extends JFrame {
    @Autowired
    private ProductService productService;

    private DefaultTableModel tableModel;
    public InventarioGrande() {
        initComponents();
        setExtendedState(InventarioGrande.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void initComponents() {

        fondoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mostrarButton = new javax.swing.JButton();
        agregarButton = new javax.swing.JButton();
        actualizarButton1 = new javax.swing.JButton();
        buscarButton1 = new javax.swing.JButton();
        eliminarButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setResizable(false);
        getContentPane().setBackground(new java.awt.Color(221, 202, 155));
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png"))).getImage());

        ImageIcon logoIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/inventario.png")));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        fondoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fondoLabel.setIcon(new ImageIcon(scaledLogo));
        fondoLabel.setPreferredSize(new Dimension(500, 500));


        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Precio", "Stock"}
        );
        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        fondoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));


        jScrollPane1.setViewportView(jTable1);

        mostrarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mostrarButton.setForeground(new java.awt.Color(45, 77, 90));
        mostrarButton.setText("Mostrar");
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarProductos();
            }
        });

        agregarButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        agregarButton.setForeground(new java.awt.Color(45, 77, 90));
        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el nombre del producto:");
                String precioStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el precio del producto:");
                String stockStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el stock del producto:");

                try {
                    double precio = Double.parseDouble(precioStr);
                    int stock = Integer.parseInt(stockStr);
                    Products nuevoProducto = new Products(nombre, precio, stock);
                    productService.createProduct(nuevoProducto);
                    cargarProductos();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(InventarioGrande.this, "Error: Ingrese un número válido para precio y stock.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        actualizarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        actualizarButton1.setForeground(new java.awt.Color(45, 77, 90));
        actualizarButton1.setText("Actualizar");
        actualizarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idActualizarStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el ID del producto a actualizar:");
                if (idActualizarStr != null && !idActualizarStr.isEmpty()) {
                    try {
                        long idActualizar = Long.parseLong(idActualizarStr);
                        String nombre = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el nuevo nombre del producto:");
                        String precioStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el nuevo precio del producto:");
                        String stockStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el nuevo stock del producto:");

                        try {
                            double precio = Double.parseDouble(precioStr);
                            int stock = Integer.parseInt(stockStr);
                            Products productoActualizado = new Products(nombre, precio, stock);
                            productService.updateProduct(idActualizar, productoActualizado);
                            cargarProductos(); // Actualizar la tabla después de actualizar el producto
                            JOptionPane.showMessageDialog(InventarioGrande.this, "Producto actualizado correctamente.", "Actualizar Producto", JOptionPane.INFORMATION_MESSAGE);

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(InventarioGrande.this, "Error: Ingrese un número válido para precio y stock.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(InventarioGrande.this, "Error: Ingrese un número válido para el ID.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(InventarioGrande.this, "Ingrese el ID del producto a actualizar.", "Actualizar Producto", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        buscarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        buscarButton1.setForeground(new java.awt.Color(45, 77, 90));
        buscarButton1.setText("Buscar");
        buscarButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorId();
            }
        });

        eliminarButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarButton1.setForeground(new java.awt.Color(45, 77, 90));
        eliminarButton1.setText("Eliminar");
        eliminarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idEliminarStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el ID del producto a eliminar:");
                if (idEliminarStr != null && !idEliminarStr.isEmpty()) {
                    try {
                        long idEliminar = Long.parseLong(idEliminarStr);
                        productService.deleteProduct(idEliminar);
                        cargarProductos(); // Actualizar la tabla después de eliminar el producto
                        JOptionPane.showMessageDialog(InventarioGrande.this, "Producto eliminado correctamente.", "Eliminar Producto", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(InventarioGrande.this, "Error: Ingrese un número válido para el ID.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(InventarioGrande.this, "Ingrese el ID del producto a eliminar.", "Eliminar Producto", JOptionPane.WARNING_MESSAGE);
                }
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
                                                        .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
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

    private void cargarProductos() {
        if (productService == null) {
            System.err.println("ProductService is null. No se pueden cargar productos.");
            return;
        }

        tableModel.setRowCount(0);
        List<Products> productos = productService.getAllProducts();
        for (Products producto : productos) {
            Object[] row = {
                    producto.getId(),
                    producto.getName(),
                    producto.getPrice(),
                    producto.getStock()
            };
            tableModel.addRow(row);
        }
    }

    private void buscarProductoPorId() {
        String idBuscarStr = JOptionPane.showInputDialog(InventarioGrande.this, "Ingrese el ID del producto a buscar:");
        if (idBuscarStr != null && !idBuscarStr.isEmpty()) {
            try {
                long idBuscar = Long.parseLong(idBuscarStr);
                Optional<Products> productoOptional = productService.findById(idBuscar);
                if (productoOptional.isPresent()) {
                    Products producto = productoOptional.get();
                    tableModel.setRowCount(0);
                    Object[] row = {
                            producto.getId(),
                            producto.getName(),
                            producto.getPrice(),
                            producto.getStock()
                    };
                    tableModel.addRow(row);
                } else {
                    JOptionPane.showMessageDialog(InventarioGrande.this, "Producto no encontrado.", "Buscar Producto", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(InventarioGrande.this, "Error: Ingrese un número válido para el ID.", "Error de entrada", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(InventarioGrande.this, "Ingrese el ID del producto a buscar.", "Buscar Producto", JOptionPane.WARNING_MESSAGE);
        }
    }


    private javax.swing.JButton actualizarButton1, agregarButton,buscarButton1,eliminarButton1,mostrarButton;
    private javax.swing.JLabel fondoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}
