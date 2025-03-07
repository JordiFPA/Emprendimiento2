package edu.ecu.ec.ProyectoEmprendimiento.Services;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Client;
import edu.ecu.ec.ProyectoEmprendimiento.Models.Invoice;
import edu.ecu.ec.ProyectoEmprendimiento.Models.ProductSale;
import edu.ecu.ec.ProyectoEmprendimiento.Models.Products;
import edu.ecu.ec.ProyectoEmprendimiento.Repositorios.ClientRepository;
import edu.ecu.ec.ProyectoEmprendimiento.Repositorios.InvoiceRepository;
import edu.ecu.ec.ProyectoEmprendimiento.Repositorios.ProductRepository;
import edu.ecu.ec.ProyectoEmprendimiento.Repositorios.ProductoSaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductoSaleRepository productSaleRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Invoice createSalesOrder(Client client, List<ProductSale> productSales) {
        double subtotal = 0.0;
        double iva = 0.0;

        // Update inventory and calculate subtotal
        for (ProductSale productSale : productSales) {
            Products product = productRepository.findById(productSale.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            if (product.getStock() < productSale.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }
            product.setStock(product.getStock() - productSale.getQuantity());
            productRepository.save(product);

            double totalProducto = product.getPrice() * productSale.getQuantity();
            subtotal += totalProducto;

            // Verificar si el producto es gasolina y no incluir IVA
            if (!product.getName().equalsIgnoreCase("EXTRA") &&
                    !product.getName().equalsIgnoreCase("SUPER") &&
                    !product.getName().equalsIgnoreCase("DIESEL")) {
                iva += totalProducto * 0.15; // Solo se agrega IVA si no es gasolina
            }
        }

        double totalAmount = subtotal + iva;

        Invoice invoice = new Invoice(client, productSales, totalAmount, LocalDate.now());
        return invoiceRepository.save(invoice);
    }

    public Invoice getLastSaleOrder() {
        return invoiceRepository.findTopByOrderByIssueDateDesc()
                .orElseThrow(() -> new RuntimeException("No sales found"));
    }

}