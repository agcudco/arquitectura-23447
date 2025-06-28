package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
