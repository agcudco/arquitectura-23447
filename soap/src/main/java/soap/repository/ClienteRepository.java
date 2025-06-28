package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
