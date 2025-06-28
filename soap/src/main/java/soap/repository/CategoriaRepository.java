package soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import soap.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
