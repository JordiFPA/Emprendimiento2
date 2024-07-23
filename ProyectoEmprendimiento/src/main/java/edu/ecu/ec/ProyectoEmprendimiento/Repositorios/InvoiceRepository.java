package edu.ecu.ec.ProyectoEmprendimiento.Repositorios;

import edu.ecu.ec.ProyectoEmprendimiento.Models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    Optional<Invoice> findTopByOrderByIssueDateDesc();
}
