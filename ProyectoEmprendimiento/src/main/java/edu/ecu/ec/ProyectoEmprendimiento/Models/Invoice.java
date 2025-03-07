package edu.ecu.ec.ProyectoEmprendimiento.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<ProductSale> productSales;

    @Column(name = "Fecha_emision")
    private LocalDate issueDate;

    @Column(name = "total_amount")
    private double totalAmount;


    public Invoice() {}

    public Invoice(Client client, List<ProductSale> productSales, double totalAmount,LocalDate issueDate) {
        this.client = client;
        this.productSales = productSales;
        this.totalAmount = totalAmount;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProductSale> getProductSales() {
        return productSales;
    }

    public void setProductSales(List<ProductSale> productSales) {
        this.productSales = productSales;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", client=" + client +
                ", productSales=" + productSales +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
