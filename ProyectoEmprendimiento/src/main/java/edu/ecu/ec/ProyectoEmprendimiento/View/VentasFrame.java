package edu.ecu.ec.ProyectoEmprendimiento.View;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import edu.ecu.ec.ProyectoEmprendimiento.Models.*;
import edu.ecu.ec.ProyectoEmprendimiento.Services.ClientService;
import edu.ecu.ec.ProyectoEmprendimiento.Services.ProductService;
import edu.ecu.ec.ProyectoEmprendimiento.Services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.property.UnitValue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Calendar;

@Component
public class VentasFrame extends JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private java.awt.Panel panel1;
    private int cantidadGasolina = 0;
    private String tipoGasolina = "";
    private double subtotal = 0;
    private double iva = 0;
    private double total = 0;
    private String RUC = "1752908086001";
    private String DireccionEmpresa = "Av.America y La Gasca";
    private Color colorPredeterminadoBoton;


    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SaleService saleService;
    private List<ProductSale> productosVenta = new ArrayList<>();
    @Autowired
    private ApplicationContext applicationContext;

    private Client client = new Client();

    public VentasFrame() throws Exception {
        try {
            initComponents();
            inicializarColoresBotones();
            addWindowListener(new WindowAdapter() {
                                  @Override
                                  public void windowOpened(WindowEvent e) {
                                      formWindowOpened(e);
                                  }

                                  @Override
                                  public void windowClosing(WindowEvent e) {
                                    formWindowClosing(e);
                                  }
                              });

                    initTableMouseListener();
            setExtendedState(VentasFrame.MAXIMIZED_BOTH);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        } catch (Exception ex) {

            ex.printStackTrace(); // Imprime la traza de la excepción en consola
        }
    }

    private void initComponents() {


        panel1 = new java.awt.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(221, 202, 155));

        panel1.setBackground(new java.awt.Color(221, 202, 155));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 44)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 42, 54));
        jLabel1.setText("DATOS:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setText("DIRECCIÓN:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel3.setText("NOMBRE:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("PLACA:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("EMAIL:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("TELÉFONO:");
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/logo.png"))).getImage());

        jTextField1.setFont(new java.awt.Font("Segoe UI", 3, 20));
        jTextField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField5.requestFocus();
            }
        });

        jTextField2.setFont(new java.awt.Font("Segoe UI", 3, 20));
        jTextField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField4.requestFocus();
            }
        });// NOI18N

        jTextField3.setFont(new java.awt.Font("Segoe UI", 3, 20));
        jTextField3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                handlePlacaEnter();
                jTextField1.requestFocus();
            }
        });

        jTable1.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Nombre", "Precio", "Cantidad"}));

        jTextField5.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jTextField5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField2.requestFocus();
            }
        });
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 44)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(11, 42, 54));
        jLabel7.setText("VENTA:");

        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("AGREGAR PRODUCTO ADICIONAL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductoAdicional();
            }
        });


        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel8.setText("GASOLINA:");

        jButton3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton3.setText("EXTRA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoGasolina = "EXTRA";
                resaltarBotonGasolina(jButton3);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton4.setText("SUPER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoGasolina = "SUPER";
                resaltarBotonGasolina(jButton4);

            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton5.setText("DIESEL");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoGasolina = "DIESEL";
                resaltarBotonGasolina(jButton5);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel9.setText("CANTIDAD:");
        jLabel9.setToolTipText("");

        jButton6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton6.setText("5$");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadGasolina = 5;
                resaltarBotonCantidad(jButton6);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton7.setText("10$");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadGasolina = 10;
                resaltarBotonCantidad(jButton7);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton8.setText("20$");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadGasolina = 20;
                resaltarBotonCantidad(jButton8);
            }
        });
        jTextField4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextField4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               manejarAccion();
            }
        });

        jTextField6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTextField6.setToolTipText("Ingrese Cantidad de Gasolina");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadGasolina = Integer.parseInt(jTextField6.getText());
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jButton9.setText("AGREGAR");
        jButton9.addActionListener(evt -> gasolinaProducto());


        jButton10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton10.setText("COMPLETAR VENTA");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarVenta();
            }
        });
        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setText("METODO PAGO:");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"SELECCIONE", "TARJETA CREDITO", "EFECTIVO"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setText("IVA (15%)");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setText("Subtotal");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel13.setText("Total");


        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(39, 39, 39)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                                .addGap(110, 110, 110)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18))
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGap(50, 50, 50)
                                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(89, 89, 89)
                                                                                .addComponent(jButton9)))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGap(39, 39, 39)
                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(80, 80, 80)
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(59, 59, 59)
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addGap(85, 85, 85)
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(111, 111, 111)
                                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(181, 181, 181)
                                                                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                                .addGap(26, 26, 26)
                                                                                .addComponent(jButton1)))))
                                                .addContainerGap(787, Short.MAX_VALUE))))
        );
        panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(panel1Layout.createSequentialGroup()
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton9)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel11)
                                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel13))
                                                .addGap(40, 40, 40))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                                .addGap(74, 74, 74)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(129, 129, 129))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void initTableMouseListener() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Doble clic para eliminar el producto
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        eliminarProductoDeVenta(selectedRow);
                    }
                }
            }
        });
    }

    private void eliminarProductoDeVenta(int rowIndex) {
        productosVenta.remove(rowIndex);
        actualizarTablaProductos();
        actualizarTotalVenta();
    }

    private void handlePlacaEnter() {
        String placa = jTextField3.getText();
        client = clientService.findByPlaca(placa);

        if (client != null) {
            jTextField1.setText(client.getName_client());
            jTextField2.setText(client.getDir());
            jTextField4.setText(client.getPhone());
            jTextField5.setText(client.getEmail());
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
            jTextField4.setEnabled(false);
            jTextField5.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no registrado");
        }
    }

    private void CrearClient() {
        String placa = jTextField3.getText().toUpperCase();
        client = clientService.findByPlaca(placa);
        if (client == null) {
            client = new Client();
            client.setPlaca(placa);
            client.setName_client(jTextField1.getText());
            client.setDir(jTextField2.getText());
            client.setPhone(jTextField4.getText());
            client.setEmail(jTextField5.getText());
            clientService.save(client);
            JOptionPane.showMessageDialog(null, "Cliente creado con éxito");
        }
    }

    private void gasolinaProducto() {
        Products gasolina = productService.getProductByName(tipoGasolina);
        double precioPorGalon = gasolina.getPrice();
        double cantidadEnGalones = cantidadGasolina / precioPorGalon;
        agregarProductoAVenta(gasolina, cantidadEnGalones);
    }

    private void agregarProductoAdicional() {
        long id = Long.parseLong(JOptionPane.showInputDialog(VentasFrame.this, "Ingrese el id del producto adcional"));
        Optional<Products> producto = productService.findById(id);
        if (producto.isPresent()) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(VentasFrame.this, "Ingrese la cantidad del producto"));
            agregarProductoAVenta(producto.orElse(null), cantidad);
        } else {
            JOptionPane.showMessageDialog(VentasFrame.this, "Producto no encontrado");
        }
    }

    private void agregarProductoAVenta(Products producto, double cantidadEnGalones) {
        ProductSale productSale = new ProductSale();
        productSale.setProduct(producto);
        productSale.setQuantity(cantidadEnGalones);
        productosVenta.add(productSale);
        actualizarTablaProductos();
        actualizarTotalVenta();
    }

    private void actualizarTablaProductos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Clear existing rows
        for (ProductSale productSale : productosVenta) {
            String nombreProducto = productSale.getProduct().getName();
            String precioProducto = String.format("%.2f", productSale.getProduct().getPrice());
            String cantidadProducto = String.format("%.2f", productSale.getQuantity());
            model.addRow(new Object[]{nombreProducto, precioProducto, cantidadProducto});
        }
    }

    private void actualizarTotalVenta() {
        subtotal = 0;
        iva = 0;
        total = 0;

        for (ProductSale productSale : productosVenta) {
            double precio = productSale.getProduct().getPrice();
            double cantidad = productSale.getQuantity();
            double totalProducto = precio * cantidad;

            subtotal += totalProducto;

            // Verificar si el producto es gasolina y no incluir IVA
            if (!productSale.getProduct().getName().equalsIgnoreCase("EXTRA") &&
                    !productSale.getProduct().getName().equalsIgnoreCase("SUPER") &&
                    !productSale.getProduct().getName().equalsIgnoreCase("DIESEL")) {
                iva += totalProducto * 0.15; // Solo se agrega IVA si no es gasolina
            }
        }

        total = subtotal + iva;

        jTextField7.setText(String.format("%.2f", iva));  // Campo de IVA
        jTextField9.setText(String.format("%.2f", subtotal));  // Campo de Subtotal
        jTextField8.setText(String.format("%.2f", total));  // Campo de Total
    }


    private void resetFrame() {
        // Limpiar los campos de texto
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");

        // Restablecer la selección en el comboBox
        jComboBox1.setSelectedIndex(0);

        // Limpiar la lista de productos de venta
        productosVenta.clear();
        actualizarTablaProductos();

        // Reiniciar las variables de venta
        cantidadGasolina = 0;
        tipoGasolina = "";
        subtotal = 0;
        iva = 0;
        total = 0;

        // Habilitar los campos de texto del cliente
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField5.setEnabled(true);
        restablecerColoresBotones();
    }

    private void guardarVenta() {
        if (client != null && !productosVenta.isEmpty()) {
            try {
                actualizarTablaProductos();
                actualizarTotalVenta();
                if (manejarMetodoPago()) {
                    Invoice invoice = saleService.createSalesOrder(client, productosVenta);
                    JOptionPane.showMessageDialog(this, "Venta guardada exitosamente.");
                    String pdfPath = generateInvoicePdf(invoice, client, productosVenta);

                    // Limpiar la lista de productos de venta
                    productosVenta.clear();

                    // Preguntar si desea abrir el PDF
                    int option = JOptionPane.showConfirmDialog(this, "¿Desea abrir el PDF generado?", "Abrir PDF", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        abrirPdf(pdfPath);
                    }

                    // Restablecer el frame para una nueva venta
                    resetFrame();

                } else {
                    JOptionPane.showMessageDialog(this, "Datos de pago erróneos. Intente nuevamente.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al guardar la venta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se puede guardar la venta. Verifique los datos del cliente y los productos.");
        }
    }


    private String generateInvoicePdf(Invoice invoice, Client client, List<ProductSale> productSaleList) throws Exception {
        Login login = applicationContext.getBean(Login.class);
        Trabajadores trabajadorActual = login.getTrabajadorActual();

        String destFolder = "Facturas";
        String destFileName = "invoice_" + invoice.getId() + ".pdf";
        String dest = destFolder + File.separator + destFileName;
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream("logo.png");
        if (imageStream == null) {
            System.err.println("Logo image not found in resources.");
            return null;
        }

        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            document.setMargins(20, 20, 20, 20);

            // Añadir logo
            Image logo = new Image(ImageDataFactory.create(imageStream.readAllBytes()));
            logo.setFixedPosition(20, 725); // Posición del logo en la esquina superior izquierda
            logo.scaleToFit(100, 100); // Escalar el logo para que se ajuste
            document.add(logo);

            // Crear un div para la información de la empresa y posicionarlo a la derecha del logo
            Div companyInfo = new Div();
            companyInfo.setFixedPosition(250, 705, 300); // Ajusta la posición vertical del contenido a la derecha del logo
            companyInfo.setTextAlignment(TextAlignment.RIGHT);

            // Añadir información de la empresa al div
            Paragraph companyDetails = new Paragraph()
                    .add("Factura ID: " + invoice.getId() + "\n")
                    .add("Fecha Emision: " + invoice.getIssueDate() + "\n")
                    .add("RUC Empresa: " + RUC + "\n")
                    .add("Dirección: " + DireccionEmpresa + "\n")
                    .add("Despachador: " + trabajadorActual.getNombre() + "\n");

            companyInfo.add(companyDetails);

            document.add(companyInfo);

            // Añadir mucho espacio adicional antes de la información del cliente
            document.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n")); // Ajusta el espacio para bajar la información del cliente

            // Añadir información del cliente
            Paragraph clientInfo = new Paragraph()
                    .add("Placa: " + client.getPlaca() + "\n")
                    .add("Nombre: " + client.getName_client() + "\n")
                    .add("Email: " + client.getEmail() + "\n")
                    .add("Phone: " + client.getPhone() + "\n")
                    .add("Dirección: " + client.getDir() + "\n")
                    .setTextAlignment(TextAlignment.LEFT);
            document.add(clientInfo);

            document.add(new Paragraph("\n\n\n"));

            // Crear tabla de productos
            float[] columnWidths = {1, 5, 2, 2};
            Table table = new Table(UnitValue.createPercentArray(columnWidths));
            table.setWidth(UnitValue.createPercentValue(100)); // Ocupa todo el espacio horizontal
            table.addHeaderCell(new Cell().add(new Paragraph("ID")).setBold());
            table.addHeaderCell(new Cell().add(new Paragraph("Producto")).setBold());
            table.addHeaderCell(new Cell().add(new Paragraph("Cantidad")).setBold());
            table.addHeaderCell(new Cell().add(new Paragraph("Precio")).setBold());

            // Crear una instancia de DecimalFormat para formatear a dos decimales
            DecimalFormat decimalFormat = new DecimalFormat("#.00");

            for (ProductSale productSale : productSaleList) {
                Products product = productSale.getProduct();
                String cantidadFormateada = decimalFormat.format(productSale.getQuantity()); // Formatear la cantidad

                table.addCell(new Cell().add(new Paragraph(String.valueOf(product.getId()))));
                table.addCell(new Cell().add(new Paragraph(product.getName())));
                table.addCell(new Cell().add(new Paragraph(cantidadFormateada))); // Añadir la cantidad formateada
                table.addCell(new Cell().add(new Paragraph(String.format("%.2f", product.getPrice())))); // Formatear el precio a dos decimales
            }
            document.add(table);

            document.add(new Paragraph("\n\n\n")); // Espacio adicional

            // Crear tabla de totales
            Table totalsTable = new Table(UnitValue.createPercentArray(new float[]{4, 2}));
            totalsTable.setWidth(UnitValue.createPercentValue(50)); // Ajusta el ancho de la tabla de totales
            totalsTable.setHorizontalAlignment(HorizontalAlignment.RIGHT); // Alinea la tabla a la derecha

            // Añadir filas de totales
            totalsTable.addCell(new Cell().add(new Paragraph("Subtotal:")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            totalsTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", subtotal))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            totalsTable.addCell(new Cell().add(new Paragraph("IVA (15%):")).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            totalsTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", iva))).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

            totalsTable.addCell(new Cell().add(new Paragraph("Total:")).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));
            totalsTable.addCell(new Cell().add(new Paragraph(String.format("%.2f", total))).setBorder(Border.NO_BORDER).setBold().setTextAlignment(TextAlignment.RIGHT));

            document.add(totalsTable);

            document.close();
            System.out.println("Factura PDF generada en: " + dest);
            return dest; // Retornar la ruta del archivo PDF generado
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean manejarMetodoPago() {
        String metodoPago = (String) jComboBox1.getSelectedItem();

        if ("TARJETA CREDITO".equals(metodoPago)) {
            JDialog dialog = new JDialog(this, "Ingrese los detalles de la tarjeta de crédito", true);
            dialog.setLayout(new GridLayout(5, 2));

            JTextField numeroTarjeta = new JTextField();
            JTextField mesExpiracion = new JTextField();
            JTextField anoExpiracion = new JTextField();
            JTextField cvv = new JTextField();

            dialog.add(new JLabel("Número de tarjeta:"));
            dialog.add(numeroTarjeta);
            dialog.add(new JLabel("Mes de expiración (MM):"));
            dialog.add(mesExpiracion);
            dialog.add(new JLabel("Año de expiración (YYYY):"));
            dialog.add(anoExpiracion);
            dialog.add(new JLabel("CVV:"));
            dialog.add(cvv);

            JButton botonAceptar = new JButton("Aceptar");
            JButton botonCancelar = new JButton("Cancelar");

            dialog.add(botonAceptar);
            dialog.add(botonCancelar);

            // Configurar el panel de botones
            JPanel botonesPanel = new JPanel();
            botonesPanel.add(botonAceptar);
            botonesPanel.add(botonCancelar);

            // Configurar los KeyListeners para cambiar de campo con Enter
            numeroTarjeta.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        mesExpiracion.requestFocus();
                    }
                }
            });

            mesExpiracion.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        anoExpiracion.requestFocus();
                    }
                }
            });

            anoExpiracion.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        cvv.requestFocus();
                    }
                }
            });

            cvv.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        botonAceptar.doClick();
                    }
                }
            });

            // Configurar el botón Aceptar
            botonAceptar.addActionListener(e -> {
                if (validarDatosTarjeta(numeroTarjeta.getText(), mesExpiracion.getText(), anoExpiracion.getText(), cvv.getText())) {
                    JOptionPane.showMessageDialog(dialog, "Pago con tarjeta de crédito aceptado.");
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Detalles de tarjeta de crédito no válidos.");
                }
            });

            // Configurar el botón Cancelar
            botonCancelar.addActionListener(e -> {
                JOptionPane.showMessageDialog(dialog, "Pago con tarjeta de crédito cancelado.");
                dialog.dispose();
            });

            dialog.pack();
            dialog.setLocationRelativeTo(this);
            dialog.setVisible(true);

            return validarDatosTarjeta(numeroTarjeta.getText(), mesExpiracion.getText(), anoExpiracion.getText(), cvv.getText());
        } else if ("EFECTIVO".equals(metodoPago)) {
            String valorEfectivo = JOptionPane.showInputDialog(this, "Ingrese el valor del efectivo:");
            try {
                double efectivo = Double.parseDouble(valorEfectivo);
                double totalFactura = total; // Método para obtener el total de la factura
                if (efectivo >= totalFactura) {
                    double vuelto = efectivo - totalFactura;
                    JOptionPane.showMessageDialog(this, "Pago en efectivo aceptado. Vuelto: " + vuelto);
                    return true; // Pago aceptado
                } else {
                    JOptionPane.showMessageDialog(this, "El efectivo ingresado es insuficiente para cubrir el total de la factura.");
                    return false; // Efectivo insuficiente
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Valor ingresado no válido. Por favor, ingrese un número.");
                return false; // Valor ingresado no válido
            }
        }
        return false;
    }

    private boolean validarDatosTarjeta(String numeroTarjeta, String mesExpiracion, String anoExpiracion, String cvv) {
        return validarNumeroTarjeta(numeroTarjeta) &&
                validarMesExpiracion(mesExpiracion) &&
                validarAnoExpiracion(anoExpiracion) &&
                validarCVV(cvv);
    }

    private boolean validarNumeroTarjeta(String numeroTarjeta) {
        return numeroTarjeta.matches("\\d{16}");
    }

    private boolean validarMesExpiracion(String mesExpiracion) {
        try {
            int mes = Integer.parseInt(mesExpiracion);
            return mes >= 1 && mes <= 12;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarAnoExpiracion(String anoExpiracion) {
        try {
            int ano = Integer.parseInt(anoExpiracion);
            int anoActual = Calendar.getInstance().get(Calendar.YEAR);
            return ano >= anoActual;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validarCVV(String cvv) {
        return cvv.matches("\\d{3,4}");
    }


    private void abrirPdf(String filePath) {
        if (Desktop.isDesktopSupported()) {
            try {
                File pdfFile = new File(filePath);
                if (pdfFile.exists()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(this, "El archivo PDF no se encontró.");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al intentar abrir el archivo PDF: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Abrir archivos PDF no es compatible en este sistema.");
        }
    }

    private void inicializarColoresBotones() {
        colorPredeterminadoBoton = UIManager.getColor("Button.background");
    }

    private void restablecerColoresBotones() {
        // Restablecer el color de fondo de todos los botones a su color original
        jButton3.setBackground(colorPredeterminadoBoton);
        jButton4.setBackground(colorPredeterminadoBoton);
        jButton5.setBackground(colorPredeterminadoBoton);
        jButton6.setBackground(colorPredeterminadoBoton);
        jButton7.setBackground(colorPredeterminadoBoton);
        jButton8.setBackground(colorPredeterminadoBoton);
    }

    private void resaltarBotonGasolina(JButton botonSeleccionado) {
        // Restablecer el color de fondo de los botones de gasolina a su color original
        jButton3.setBackground(colorPredeterminadoBoton);
        jButton4.setBackground(colorPredeterminadoBoton);
        jButton5.setBackground(colorPredeterminadoBoton);

        // Resaltar el botón seleccionado
        botonSeleccionado.setBackground(Color.LIGHT_GRAY); // Puedes usar cualquier color de resaltado
    }

    private void resaltarBotonCantidad(JButton botonSeleccionado) {
        // Restablecer el color de fondo de los botones de cantidad a su color original
        jButton6.setBackground(colorPredeterminadoBoton);
        jButton7.setBackground(colorPredeterminadoBoton);
        jButton8.setBackground(colorPredeterminadoBoton);

        // Resaltar el botón seleccionado
        botonSeleccionado.setBackground(Color.LIGHT_GRAY); // Puedes usar cualquier color de resaltado
    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        resetFrame();
        restablecerColoresBotones();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
       resetFrame();
        restablecerColoresBotones();
    }

    private boolean validarCampos() {
        // Verifica si algún campo está vacío
        if (jTextField1.getText().trim().isEmpty()) {
            mostrarError("El campo NOMBRE no puede estar vacío.");
            return false;
        }
        if (jTextField2.getText().trim().isEmpty()) {
            mostrarError("El campo DIRECCIÓN no puede estar vacío.");
            return false;
        }
        if (jTextField3.getText().trim().isEmpty()) {
            mostrarError("El campo PLACA no puede estar vacío.");
            return false;
        }
        if (jTextField4.getText().trim().isEmpty()) {
            mostrarError("El campo TELÉFONO no puede estar vacío.");
            return false;
        }
        if (jTextField5.getText().trim().isEmpty()) {
            mostrarError("El campo EMAIL no puede estar vacío.");
            return false;
        }
        return true;
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void manejarAccion() {
        if (validarCampos()) {
            CrearClient();
        }
    }




}

