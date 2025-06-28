package soap.services.impl;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import soap.model.Categoria;
import soap.repository.CategoriaRepository;
import soap.services.CategoriaService;

import java.util.List;
import java.util.Optional;

@Component
@WebService(endpointInterface = "soap.services.CategoriaService",
        serviceName = "CategoriaService")
public class CategoriaServicesImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean deleteCategoria(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
